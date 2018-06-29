//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.deckcomponents.PlayerDeckBuild;
import lordoftherings.deckcomponents.EncounterBuild;
import lordoftherings.deckcomponents.Quest;
import lordoftherings.matcher.HeroMatcher;
import lordoftherings.matcher.Matcher;
import lordoftherings.matcher.ReadyMatcher;
import lordoftherings.phasemanager.PhaseManagerGovenor;
import lordoftherings.PlayerCardType;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.GameCharacter;
import lordoftherings.characters.Enemy;
import lordoftherings.characters.Hero;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.GameManager;
import lordoftherings.transaction_managers.PlayerZoneQueryHandle;
import lordoftherings.transaction_managers.ResolveEnemyAttackHandler;
import lordoftherings.transaction_managers.ResolvePlayerAttackHandler;
import lordoftherings.transaction_managers.ResolveUndefendedEnemyAttackHandler;
import lordoftherings.transaction_managers.Uncancellable;

/**
 *
 * @author Amanda
 */
public class Board {
    private EncounterZone encounterZone;
    private PlayerDeckBuild [] deckBuilds;
    public static PlayerZone[] playerZones;
    private int currentPlayerNum;
    private GameManager gameManager;
    private boolean hasPlayerWon;
    private ArrayList<SuspensionType> currentSuspensions;
    private PhaseManagerGovenor pmGovenor;
    
    
    
    public Board(PlayerDeckBuild[] playerBuild, EncounterBuild encounterInfo, GameManager manager){
        this.encounterZone = new EncounterZone(encounterInfo, this);
        this.deckBuilds = playerBuild;
        int size = deckBuilds.length;
        this.playerZones = new PlayerZone[size];
        for(int i = 0; i < size; ++i){
            playerZones[i] = new PlayerZone(deckBuilds[i], i, this, "Player1");//TODO: replace this with an imput
        }
        this.gameManager = manager;
        this.hasPlayerWon = false;
        this.currentSuspensions = new ArrayList<>();
        this.pmGovenor = new PhaseManagerGovenor(this);
    }
    
    public PlayerZone getPlayerZoneAt(int index){
        return playerZones[index];
    }
    
    public int getNumOfPlayerZones(){
        return playerZones.length;
    }
    
    public void increaseEveryPlayersThreatBy(int num){
        for(int i = 0; i < playerZones.length; ++i){
            playerZones[i].increaseThreatBy(num);
        }
    }
    
    public PhaseManagerGovenor getPhaseManagerGovenor(){
        return pmGovenor;
    }
    
    public PlayerZone[] getPlayerZones(){
        return playerZones;
    }
    
    public EncounterDiscardPile getEnemyDiscardPile(){
        return encounterZone.getEnemyDiscardPile();
    }
    
    public PlayerDeckBuild getBuildAt(int index){
        return deckBuilds[index];
    }
    
    public GameManager getGameManager(){
        return gameManager;
    }
    
    public PlayerZone getCurrentPlayerZone(){
        return getPlayerZoneAt(currentPlayerNum);
    }
    
    public int getCurrentPlayerNum(){
        return currentPlayerNum;
    }
    
    public EncounterZone getEncounterZone(){
        return encounterZone;
    }
    
    public boolean isCurrentPlayer(int playerNum){
        return currentPlayerNum == playerNum;
    }
    
    public void addResourcesToHerosAndDraw(){
        for(int i = 0; i < playerZones.length; ++i){
            playerZones[i].drawCardFromDeckAddToHand();
            for(int j = 0; j < playerZones[i].getHeros().size(); ++j){
                playerZones[i].addResourcesToHero(j,1);
            }
        }
    }

    public void drawFromEncounterDeck() {
        encounterZone.drawCardFromEncounterDeck(this);
    }
    
    public void addEnemyToStagingArea(EnemyCard card){
        encounterZone.addEnemyToStagingArea(card);
    }

    public void resolveQuest() {
        int questPoints = 0;
        int threatPoints = encounterZone.getStagingArea().getCurrentThreat();
        for(int i = 0; i < playerZones.length; ++i){
            questPoints += playerZones[i].getCurrentQuestingTotal();
        }
        int numOfTokens = questPoints - threatPoints;
        if(numOfTokens < 0){
            for(int i = 0; i < playerZones.length; ++i){
                playerZones[i].increaseThreatBy(threatPoints - questPoints);
            }
        }else{
            ActiveLocationArea locationZone = encounterZone.getStagingArea().getActiveLocationArea();
            if(locationZone.isEmpty()){
                encounterZone.getActiveQuest().addTravelTokens(numOfTokens);
            }else{
                int tokensNeededForLocation = locationZone.getQuestPoints() - 
                        locationZone.getNumOfTokensOnActiveLocation();
                int leftOverTokens = numOfTokens - tokensNeededForLocation ;
                if(leftOverTokens > 0){
                    locationZone.getActiveLocation().addTokens(tokensNeededForLocation);
                    encounterZone.getActiveQuest().addTravelTokens(leftOverTokens);
                }else{
                    locationZone.getActiveLocation().addTokens(numOfTokens);
                }
                checkTokensOnCurrentLocation();
            }
            checkTokensOnQuest();
        }
        
    }
    
    public void checkTokensOnQuest(){
        Quest currentQuest = encounterZone.getActiveQuest();
        if(currentQuest.haveEnoughTokens()){
            encounterZone.getQuestSet().getNextQuest();
            hasGameEnded();
        }
    }
    
    public void checkTokensOnCurrentLocation(){
         Location currentLocation = encounterZone.getStagingArea().
                 getActiveLocationArea().getActiveLocation();
         if(currentLocation.getNumOfTokens() >= currentLocation.getQuestPoints()){
            encounterZone.moveCurrentLocationToDiscardPile();
        }
    }
    
    public boolean hasGameEnded(){
        if(encounterZone.getQuestSet().hasCompletedQuests()){
            hasPlayerWon = true;
            currentSuspensions.add(SuspensionType.WON);
            return true;
        }
        for(int i = 0; i < playerZones.length; ++i){
            if(playerZones[i].herosStillAlive() && 
                    playerZones[i].getCurrentThreat()<50){
                hasPlayerWon = false;
                return false;
            }
        }
        currentSuspensions.add(SuspensionType.LOST);
        return true;
    }
    
    public boolean getPlayerStatus(){
        return hasPlayerWon;
    }
    
    public void removeRecentSuspension(){
        currentSuspensions.remove(currentSuspensions.size() -1);
    }
    
    public void startAttackWithEnemy(Enemy attacker){
        currentSuspensions.add(SuspensionType.DEFEND);
        Matcher<GameCharacter> ready = new ReadyMatcher();
        CharacterQueryRequirements requirements = new CharacterQueryRequirements(ready, 0, 1);
        gameManager.handleCharacterQuery(new CharacterQueryHandle(
            requirements,
            new ResolveEnemyAttackHandler(attacker, this),
            new ClearSuspensionHandler(this)
            ),
          "Choose Defender(s) for the \n attack.");
    }
    
    public void startPlayerAttackOnEnemy(Enemy target){
        currentSuspensions.add(SuspensionType.ATTACK);
        Matcher<GameCharacter> ready = new ReadyMatcher();
        CharacterQueryRequirements requirements = new CharacterQueryRequirements(ready, 1, Integer.MAX_VALUE);
        gameManager.handleCharacterQuery(new CharacterQueryHandle(
            requirements,
            new ResolvePlayerAttackHandler(target, this),
            new ClearSuspensionHandler(this)),
            "Choose Characters to attack \n selected Enemy.");
    }
    
    public void resolveAttackOnEnemy(Enemy target, ArrayList<GameCharacter> attackers){
        int attackPower = 0;
        for(int i = 0; i < attackers.size(); ++i){
            attackPower += attackers.get(i).getAttack();
            attackers.get(i).exhaust();
        }
        int actualDamage = attackPower - target.getDefense();
        if(actualDamage > 0){
            target.assignDamage(actualDamage);
        }
        for(int i = 0; i < getNumOfPlayerZones(); ++i){
            getPlayerZoneAt(i).cleanUpEngagedEnemyArea();
        }
        removeRecentSuspension();
        target.setAttackedStatus(true);
    }
    public void resolveAttackWithDefenders(Enemy attacker, ArrayList<GameCharacter> defenders) {
        if(defenders.isEmpty()){
            HeroMatcher defender = new HeroMatcher();
            CharacterQueryRequirements requirements = new CharacterQueryRequirements(defender, 1, 1);
            gameManager.handleCharacterQuery(new CharacterQueryHandle(
                    requirements,
                    new ResolveUndefendedEnemyAttackHandler(attacker, this),
                    new Uncancellable()
                    ),
                "Choose Hero for undefended \n attack");
            return;
        }else if(defenders.size() == 1){
            GameCharacter defender = defenders.get(0);
            defender.exhaust();
            defender.assignDamageWithDefense(attacker.getAttack());
        }else{
            throw new RuntimeException();
        }
        for(int i = 0; i < getNumOfPlayerZones(); ++i){
            getPlayerZoneAt(i).cleanUpCharacterArea();
        }
        removeRecentSuspension();
        attacker.setEnemyToNotAttacking();
    }

    public void resolveAttackWithNoDefenders(Enemy attacker, ArrayList<GameCharacter> characterToDamage) {
        if(characterToDamage.get(0).getCard().getCardType() != PlayerCardType.HERO){
            throw new RuntimeException();
        }else{
            Hero heroToDamage = (Hero) characterToDamage.get(0);
            heroToDamage.assignDamage(attacker.getAttack());
        }
        for(int i = 0; i < getNumOfPlayerZones(); ++i){
            getPlayerZoneAt(i).cleanUpCharacterArea();
        }
        removeRecentSuspension();
        attacker.setEnemyToNotAttacking();
    }
    
    public void playersEngageEnemyWithClosestThreat(){
        boolean continueToEngage = enemiesLeftToEngage();
        while(continueToEngage){
            for(int i = 0; i < getNumOfPlayerZones(); ++i){
                engageEnemyByClosestThreat(i);
            }
            continueToEngage = enemiesLeftToEngage();
        }
        
    }
    
    public void engageEnemyByClosestThreat(int playerNum){
        PlayerZone playerZone = getPlayerZoneAt(playerNum);
        EnemyArea enemyArea = encounterZone.getStagingArea().getEnemyArea();
        int indexOfProperEnemy = -1;
        for(int i = 0; i < enemyArea.getNumOfEnemies(); ++i){
            Enemy currentEnemy = enemyArea.getListOfEnemies().get(i);
            if(indexOfProperEnemy == -1){
                if(currentEnemy.getThreat() <= playerZone.getCurrentThreat()){
                    indexOfProperEnemy = i;
                }
            }else{
                if(currentEnemy.getThreat() <= playerZone.getCurrentThreat() ||
                        currentEnemy.getThreat() > enemyArea.getListOfEnemies().get(i).getThreat()){
                    indexOfProperEnemy = i;
                }
            }
        }
        if(indexOfProperEnemy != -1){
            playerZone.getEngagementArea().addEnemy(encounterZone.getStagingArea().getEnemyAt(indexOfProperEnemy));
            encounterZone.getStagingArea().removeEnemyAt(indexOfProperEnemy);
        }
        
    }
    
    public boolean enemiesLeftToEngage(){
        int numOfEnemies = encounterZone.getStagingArea().getEnemyArea().getNumOfEnemies();
            for(int i = 0; i < numOfEnemies; ++i){
                Enemy currentEnemy = encounterZone.getStagingArea().getEnemyArea().getEnemyAt(i);
                int lowestPlayerThreat = getLowestPlayerThreat();
                if(currentEnemy.getThreat() <= lowestPlayerThreat){
                    return true;
                }
            }
            return false;
    }
    
    public int getLowestPlayerThreat(){
        int lowestThreat = 100;
        for(int i = 0; i < getNumOfPlayerZones(); ++i){
            if(getPlayerZoneAt(i).getCurrentThreat() < lowestThreat){
                lowestThreat = getPlayerZoneAt(i).getCurrentThreat();
            }
        }
        return lowestThreat;
    }
    
    public void handleCharacterQuery(CharacterQueryHandle handle, String description){
        gameManager.handleCharacterQuery(handle, description);
    }
    
    public void handlePlayerZoneQuery(PlayerZoneQueryHandle handle, String description){
        gameManager.handlePlayerZoneQuery(handle, description);
    }
    
    public void addSuspension(SuspensionType suspension){
        currentSuspensions.add(suspension);
    }
    
    public void removeTopSuspension(){
        currentSuspensions.remove(currentSuspensions.size()-1);
    }

}
