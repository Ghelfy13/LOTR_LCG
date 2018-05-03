//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.DeckComponents.EncounterBuild;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cards.EncounterCard;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;
import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.PhaseManager.GamePhase;

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

    public EncounterZone(EncounterBuild questInfo, Board board){
        encounterDiscard = new EncounterDiscardPile();
        stage = new StagingArea();
        this.encounterDeck = new EncounterDeck(questInfo.getEnemyDeck());
        // TODO: distinguish quest set build from quest cards in the board.
        this.quests = questInfo.getQuestDeck();
        this.board = board;
    }

    public EncounterDeck getEncounterDeck() {
        return encounterDeck;
    }
    
    public StagingArea getStagingArea(){
        return stage;
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
    
    public void discardDeadEnemy(EncounterCard deadCard){
        encounterDiscard.addCardToPile(deadCard);
    }

    public GamePhase getCurrentPhase() {
        return board.getCurrentPhase();
    }
    
    public EncounterDiscardPile getEnemyDiscardPile(){
        return encounterDiscard;
    }
    
}
