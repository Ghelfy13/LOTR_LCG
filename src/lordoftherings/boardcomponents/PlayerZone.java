//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;
import lordoftherings.cards.AllyCard;
import lordoftherings.cards.PlayerCard;
import java.util.ArrayList;
import lordoftherings.characters.Ally;
import lordoftherings.deckcomponents.PlayerDeckBuild;
import lordoftherings.LocationOnBoard;
import lordoftherings.characters.Hero;
/**
 *
 * @author Amanda
 */
public class PlayerZone {
    private Hand playersHand;
    private PlayerDeck playersDeck;
    private DiscardPile dPile;
    private Field field;
    private int ownerID;
    private ThreatDial threatDial;
    private Board board;
    private boolean playerIsAlive;
    private PlayerName name;
    private int playerThreat;
    private ArrayList<Hero> deadHeros;
    
    
    public PlayerZone(PlayerDeckBuild playerDeckAndHeros, int ownerID, Board board, String name){
        playersHand = new Hand(ownerID);
        playersDeck = new PlayerDeck(ownerID, playerDeckAndHeros.getPlayersDeck());
        playersDeck.shuffle();
        dPile = new DiscardPile(ownerID);
        field = new Field(playerDeckAndHeros.getHeros(), ownerID, this);
        this.ownerID = ownerID;
        this.board = board;
        this.playerIsAlive = true;
        this.name = new PlayerName(ownerID, this, name);
        this.threatDial = new ThreatDial(field.getInitinalThreat(), ownerID, this);
        deadHeros = new ArrayList<>();
    }
    
    public Board getBoard(){
        return board;
    }
    
    public boolean isPlayerAlive(){
        return playerIsAlive;
    }
    
    public String getPlayerName(){
        return name.getPlayerName();
    }
    
    public boolean herosStillAlive(){
        HeroArea area = field.getCharacterZone().getHeroArea();
        if(area.isEmpty()){
            playerIsAlive = false;
            return false;
        }
        return true;
    }
    
    public void healAllHeros(){
        HeroArea area = field.getCharacterZone().getHeroArea();
        for(int i = 0; i < area.getNumOfHeros(); ++i){
            int damage = area.getHeroAt(i).getDamage();
            area.getHeroAt(i).removeDamage(damage);
        }
    }
    
    public void payForCard(int cost){
        HeroArea area = field.getCharacterZone().getHeroArea();
        for(int i = 0; i < area.getNumOfHeros(); ++i){
            Hero currentHero = area.getHeroAt(i);
            int currentHeroResources = currentHero.getNumOfResources();
            if(currentHeroResources < cost){
                currentHero.spendResources(currentHeroResources);
                cost -= currentHeroResources;
            }else{
                currentHero.spendResources(cost);
                break;
            }
        }
    }
    
    public Field getField(){
        return field;
    }
    
    public int getInitialHeroThreat(){
        return field.getInitinalThreat();
    }
    
    public CharacterArea getCharZone(){
        return field.getCharacterZone();
    }
    
    public int getCurrentPlayerThreat(){
        return threatDial.getThreat();
    }
    
    public void increaseThreatBy(int num){
        threatDial.increaseThreat(num);
    }
    
    public EngagedEnemyArea getEngagementArea(){
        return field.getEngagementArea();
    }
    
    public Hand getHand(){
        return playersHand;
    }
    
    public ArrayList<Ally> getAllies(){
        return field.getCharacterZone().getAllyArea().getAllies();
    }
    
    public PlayerDeck getDeck(){
        return playersDeck;
    }
    
    public DiscardPile getDPile(){
        return dPile;
    }
    
    public ArrayList<Hero> getHeros(){
        return field.getCharacterZone().getHeroArea().getHeros();
    }
    
    public int getOwner(){
        return ownerID;
    }
    
    public void unsetCommittedCharacters(){
        field.getCharacterZone().getAllyArea().unCommittAllies();
        field.getCharacterZone().getHeroArea().unCommittHeros();
    }
    
    public boolean hasEngagedEnemy(){
        return field.hasEngagedEnemyYet();
    }
    
    public void setEngagedEnemyYet(boolean bool){
        field.setEngagedEnemyYet(bool);
    }
    
    public boolean moveAllyFromHandToField(AllyCard allyBeingPlayed){
            if(playersHand.removeCard(allyBeingPlayed) == null){
                throw new IllegalStateException("failed to remove card");
            }
            playersHand.removeCard(allyBeingPlayed);
            return field.addAllyToCharacterZone(allyBeingPlayed);
        
    }
    
    public void drawCardFromDeckAddToHand(){
        if(playersDeck.getSize() != 0){
            PlayerCard drawnCard = playersDeck.pop();
            playersHand.addCard(drawnCard);
        }
    }
    
    public void addListOfAllies(ArrayList<AllyCard> list){
        field.getCharacterZone().addListOfAllies(list);
    }
    
    public int getHerosResources(){
        return field.getCharacterZone().getHeroArea().sumOfResources();
    }
    
    public void addResourcesToHero(int heroIndex, int numOfResources){
        field.getCharacterZone().getHeroArea().addResourcesToHero(heroIndex, numOfResources);
    }

    public void readyCharacters() {
        field.getCharacterZone().getAllyArea().readyAllies();
        field.getCharacterZone().getHeroArea().readyHeros();
    }

    public int getCurrentQuestingTotal() {
        int questingTotal = 0;
        questingTotal += field.getCharacterZone().getHeroArea().getQuestingTotal();
        questingTotal += field.getCharacterZone().getAllyArea().getQuestingTotal();
        return questingTotal;
    }

    public void moveCardToDiscardPile(PlayerCard deadCard){//Does not remove from original location
        dPile.addCard(deadCard);
        deadCard.setLocation(ownerID, LocationOnBoard.DISCARDPILE);
        
    }
    
    public void addDeadHeroToList(Hero deadHero){
        deadHeros.add(deadHero);
    }
    
    public int getTotalDamageOnHeros(){
        return field.getCharacterZone().getTotalDamageOnHeros();
    }
    
    public int getSumOfThreatOfDeadHeros(){
        int deadsThreat = 0;
        for(int i = 0; i < deadHeros.size(); ++i){
            deadsThreat += deadHeros.get(i).getThreatCost();
        }
        return deadsThreat;
    }
    
    public void cleanUpCharacterArea(){
        field.getCharacterZone().moveDeadAllysToDiscardPile();
        field.getCharacterZone().moveDeadHerosToDiscardPile();
    }
    
    public void cleanUpEngagedEnemyArea(){
        field.getEngagementArea().cleanUpEngagedEnemyArea();
    }

    public void setEnemiesToAttackedAndDefended() {
        field.getEngagementArea().resetFightingStatus();
    }
    
    public EncounterDiscardPile getEnemyDiscardPile(){
        return board.getEnemyDiscardPile();
    }

    public void clearUpPhaseModifiers() {
        field.getCharacterZone().cleanUpPhaseModifiers();
    }
    
    public void reshuffleDiscardPile(){
        for(int i = 0; i < dPile.getSize(); ++i){
            playersDeck.addCard(dPile.removeTopCard());
        }
        playersDeck.shuffle();
    }

    
}
