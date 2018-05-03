//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import lordoftherings.DeckComponents.EncounterDeckBuild;
import lordoftherings.LocationOnBoard;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cards.EncounterCard;
/**
 *
 * @author Amanda
 */
public class EncounterDeck {
    private ArrayList<EncounterCard> enemyDeck;
    
    public EncounterDeck(EncounterDeckBuild cardsToBeInDeck){
        this.enemyDeck = new ArrayList<>();
        Iterator<Map.Entry<EncounterCardModel, Integer>> deckBuilderIterator =
                cardsToBeInDeck.iterator();
        while(deckBuilderIterator.hasNext()){
            Map.Entry<EncounterCardModel,Integer> entry = deckBuilderIterator.next();
            EncounterCardModel model = entry.getKey();
            addNumOfEnemyCard(model, entry.getValue());
        }
    }
    
    public void addNumOfEnemyCard(EncounterCardModel cardModel, int numOfCards){
        for(int i = 0; i < numOfCards; ++i){
            EncounterCard card = cardModel.createCard();
            enemyDeck.add(card);
            card.setLocation(LocationOnBoard.DECK, EncounterCard.UNSET_ID);
        }
    }
    
    public int getNumOfCardsLeft(){
        return enemyDeck.size();
    }
    
    public EncounterCard drawACard(){ //Can return null
        if(enemyDeck.size() != 0){
            return enemyDeck.remove(0);
        }
        return null;
    }
}
