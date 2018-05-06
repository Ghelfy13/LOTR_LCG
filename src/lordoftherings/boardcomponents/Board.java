//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.DeckComponents.PlayerDeckBuild;
import lordoftherings.DeckComponents.EncounterBuild;
import lordoftherings.Matcher.HeroMatcher;
import lordoftherings.Matcher.Matcher;
import lordoftherings.Matcher.ReadyMatcher;
import lordoftherings.PhaseManager.CombatPhaseManager;
import lordoftherings.PhaseManager.EncounterPhaseManager;
import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.PhaseManager.PhaseManager;
import lordoftherings.PhaseManager.PlanningPhaseManager;
import lordoftherings.PhaseManager.QuestPhaseManager;
import lordoftherings.PhaseManager.RefreshPhaseManager;
import lordoftherings.PhaseManager.ResourcePhaseManager;
import lordoftherings.PhaseManager.ResourceSubPhase;
import lordoftherings.PhaseManager.SubPhase;
import lordoftherings.PhaseManager.TravelPhaseManager;
import lordoftherings.PlayerCardType;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.GameCharacter;
import lordoftherings.characters.Enemy;
import lordoftherings.characters.Hero;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.GameManager;
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
    private PhaseManager currentPhaseManager;
    private PlayerDeckBuild [] deckBuilds;
    private PlayerZone[] playerZones;
    private int currentPlayerNum;
    private ResourcePhaseManager resourcePM;
    private PlanningPhaseManager planningPM;
    private GamePhase currentGamePhase;
    private QuestPhaseManager questPM;
    private TravelPhaseManager travelPM;
    private EncounterPhaseManager encounterPM;
    private RefreshPhaseManager refreshPM;
    private CombatPhaseManager combatPM;
    private GameManager gameManager;
    private boolean isSuspended;
    
    
    public Board(PlayerDeckBuild[] playerBuild, EncounterBuild encounterInfo, GameManager manager){
        this.encounterZone = new EncounterZone(encounterInfo, this);
        this.deckBuilds = playerBuild;
        this.currentGamePhase = GamePhase.RESOURCE;
        int size = deckBuilds.length;
        this.playerZones = new PlayerZone[size];
        for(int i = 0; i < size; ++i){
            playerZones[i] = new PlayerZone(deckBuilds[i], i, this);
        }
        this.resourcePM = new ResourcePhaseManager();
        this.currentPhaseManager = resourcePM.setSubPhase(ResourceSubPhase.ADD_RESOURCES_AND_DRAW);
        currentPhaseManager.onStartSubPhase(this);
        this.planningPM = new PlanningPhaseManager();
        this.questPM = new QuestPhaseManager();
        this.travelPM = new TravelPhaseManager();
        this.encounterPM = new EncounterPhaseManager();
        this.refreshPM = new RefreshPhaseManager();
        this.combatPM = new CombatPhaseManager();
        this.gameManager = manager;
        this.isSuspended = false;
    }
    
    public PlayerZone getPlayerZoneAt(int index){
        return playerZones[index];
    }
    
    public int getNumOfPlayerZones(){
        return playerZones.length;
    }
    
    public SubPhase getCurrentSubPhase(){
        return currentPhaseManager.getSubPhase();
    }
    
    public void increaseEveryPlayersThreatBy(int num){
        for(int i = 0; i < playerZones.length; ++i){
            playerZones[i].increaseThreatBy(num);
        }
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
    
    public GamePhase getCurrentPhase(){
        return currentPhaseManager.getPhase();
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
    
    public boolean canProgressPhase(){
        return currentPhaseManager.canProgress(this);
    }
    
    public void advancePhase(){
        if(!currentPhaseManager.canProgress(this)){
            return;
        }
        currentPhaseManager.onEndSubPhase(this);
        currentPhaseManager = currentPhaseManager.getNextPhase(this);
        currentPhaseManager.onStartSubPhase(this);
    }
    
    public ResourcePhaseManager getResourcePhaseManager(){
        return resourcePM;
    }
    
    public PlanningPhaseManager getPlanningPhaseManager() {
        return planningPM;
    }
    
    public CombatPhaseManager getCombatPhaseManager(){
        return combatPM;
    }
    
    public QuestPhaseManager getQuestPhaseManager() {
        return questPM;
    }
    
    public TravelPhaseManager getTravelPhaseManager(){
        return travelPM;
    }
    
    public EncounterPhaseManager getEncounterPhaseManager(){
        return encounterPM;
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

    public RefreshPhaseManager getRefreshPhaseManager() {
        return refreshPM;
    }

    public void resolveQuest() {
        int questPoints = 0;
        int threatPoints = encounterZone.getStagingArea().getCurrentThreat();
        for(int i = 0; i < playerZones.length; ++i){
            questPoints += playerZones[i].getCurrentQuestingTotal();
        }
        if(threatPoints > questPoints){
            for(int i = 0; i < playerZones.length; ++i){
                playerZones[i].increaseThreatBy(threatPoints - questPoints);
            }
        }else{
            //TODO: ADD EXCESS TO CURRENT LOCATION/QUEST
        }
    }
    
    public void clearSuspension(){
        isSuspended = false;
    }
    
    public void startAttackWithEnemy(Enemy attacker){
        isSuspended = true;
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
        isSuspended = true;
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
        clearSuspension();
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
        clearSuspension();
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
        clearSuspension();
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

       
}
