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
    private ThreatDial currentThreat;
    private Board board;
    private boolean playerIsAlive;
    private PlayerName name;
    
    
    public PlayerZone(PlayerDeckBuild playerDeckAndHeros, int ownerID, Board board, String name){
        playersHand = new Hand(ownerID);
        playersDeck = new PlayerDeck(ownerID, playerDeckAndHeros.getPlayersDeck());
        dPile = new DiscardPile(ownerID);
        field = new Field(playerDeckAndHeros.getHeros(), ownerID, this);
        this.ownerID = ownerID;
        this.currentThreat = new ThreatDial(field.getInitinalThreat(), ownerID, this);
        this.board = board;
        this.playerIsAlive = true;
        this.name = new PlayerName(name, ownerID, this);
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
    
    public Field getField(){
        return field;
    }
    
    public int getInitialThreat(){
        return field.getInitinalThreat();
    }
    
    public CharacterArea getCharZone(){
        return field.getCharacterZone();
    }
    
    public int getCurrentThreat(){
        return currentThreat.getThreat();
    }
    
    public void increaseThreatBy(int num){
        currentThreat.increaseThreat(num);
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
    
    public void cleanUpCharacterArea(){
        field.getCharacterZone().moveDeadAllysToDiscardPile();
        field.getCharacterZone().moveDeadHerosToDiscardPile();
    }
    
    public void cleanUpEngagedEnemyArea(){
        field.getEngagementArea().moveDeadEnemiesToDiscardPile();
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

    
}
