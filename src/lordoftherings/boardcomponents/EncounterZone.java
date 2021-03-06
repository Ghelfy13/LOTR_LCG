//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.deckcomponents.EncounterBuild;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cards.EncounterCard;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;
import java.util.ArrayList;
import lordoftherings.deckcomponents.Quest;
import lordoftherings.LocationOnBoard;
import lordoftherings.cards.LocationCard;
import lordoftherings.cards.QuestCard;
import lordoftherings.phasemanager.GamePhase;

/**
 *
 * @author Amanda
 */
public class EncounterZone {
    public static final int OWNER_ID = -5;
       
    private EncounterDeck encounterDeck;
    private EncounterDiscardPile encounterDiscard;
    private QuestSet quests;
    private StagingArea stage;
    private Board board;
    private ActiveQuest activeQuest;
    private QuestDiscardPile questDiscard;

    public EncounterZone(EncounterBuild encounterSet, Board board){
        encounterDiscard = new EncounterDiscardPile();
        stage = new StagingArea();
        this.encounterDeck = new EncounterDeck(encounterSet.getEnemyDeck());
        this.quests = new QuestSet(encounterSet.getQuestDeck(), 
                encounterSet.getQuestDeck().getCardModelAt(0).getScenarioTitle());
        this.board = board;
        this.activeQuest = new ActiveQuest(new Quest(quests.getNextQuest()));
        this.questDiscard = new QuestDiscardPile();
    }

    public EncounterDeck getEncounterDeck() {
        return encounterDeck;
    }
    
    public QuestDiscardPile getQuestDiscardPile(){
        return questDiscard;
    }
    
    public QuestSet getQuestSet(){
        return quests;
    }
    
    public Quest getActiveQuest(){
        return activeQuest.getQuest();
    }
    
    public StagingArea getStagingArea(){
        return stage;
    }
    
    public void moveCurrentLocationToDiscardPile(){
        LocationCard location = stage.getActiveLocationArea().getActiveLocation().getCard();
        if(location.getVictoryPoints() != 0){
            board.getVPPile().addCard(location);
        }else{
             encounterDiscard.addCardToPile(location);
        }
        stage.getActiveLocationArea().unsetActiveLocation();
    }
    
    public void addEnemyToStagingArea(EnemyCard card){
        Enemy newEnemy = new Enemy(card);
        stage.getEnemyArea().addEnemyToList(newEnemy);
    }
    
    public void addListOfEnemiesToStagingArea(ArrayList<EnemyCard> listOfEnemies){
        for(int i = 0; i < listOfEnemies.size(); ++i){
            Enemy newEnemy = new Enemy(listOfEnemies.get(i));
            stage.getEnemyArea().addEnemyToList(newEnemy);
        }
    }
    
    public void addNumOfCardsToDeck(EncounterCardModel cardModel, int numOfCards){
        encounterDeck.addNumOfEnemyCard(cardModel, numOfCards);
    }
    
    public void drawCardFromEncounterDeck(Board board){
        EncounterCard card = encounterDeck.drawACard();
        if(card != null){
          card.afterOnWhenRevealed(board);  
          card.setLocation(LocationOnBoard.ENCOUNTER_ZONE, OWNER_ID);
        }
    }
    
    public void discardDeadEnemies(){
        ArrayList<Enemy> enemies = stage.getEnemyArea().getListOfEnemies();
        for(int i = 0; i < enemies.size(); ++i){
            Enemy current = enemies.get(i);
            if(current.getDamage() >= current.getMaxHealth()){
                if(current.getCard().getVictoryPoints() != 0){
                    board.getVPPile().addCard(current.getCard());
                }else{
                    discardDeadEnemy(current.getCard());
                }
                stage.getEnemyArea().removeEnemy(current);
            }
        }
    }
    
    public void discardCompletedQuest(QuestCard completeQuest){
        questDiscard.addCard(completeQuest);
        QuestCard nextQuest = getQuestSet().getNextQuest();
            if(nextQuest != null){
                activeQuest = new ActiveQuest(new Quest(nextQuest));
            }
    }
    
    public void discardDeadEnemy(EncounterCard deadCard){
        encounterDiscard.addCardToPile(deadCard);
    }

    public GamePhase getCurrentPhase() {
        return board.getPhaseManagerGovenor().getCurrentPhase();
    }
    
    public EncounterDiscardPile getEnemyDiscardPile(){
        return encounterDiscard;
    }
    
}
