//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.cards.PlayerCard;
import lordoftherings.cardmodel.PlayerCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import lordoftherings.DeckComponents.DeckBuild;
import lordoftherings.LocationOnBoard;
/**
 *
 * @author Amanda
 */
public class PlayerDeck {
    //contains: 3 Heros, 40 ally and event cards
    // for now, lets say there are 20 allies and 20 event cards
    private ArrayList<PlayerCard> deck;
    private int ownerID;
    
    public PlayerDeck(int ownerID, DeckBuild cardsToBeInDeck){
        this.ownerID = ownerID;
        this.deck = new ArrayList<>();
        Iterator<Map.Entry<PlayerCardModel, Integer>> deckBuilderIterator =
                cardsToBeInDeck.iterator();
        while(deckBuilderIterator.hasNext()){
            Map.Entry<PlayerCardModel, Integer> entry = deckBuilderIterator.next();
            PlayerCardModel cardModel = entry.getKey();
            int value = entry.getValue();
            for(int i = 0; i < value; ++i){
                PlayerCard card = cardModel.createCard();
                card.setOwner(ownerID);
                card.setLocation(ownerID, LocationOnBoard.DECK);
                this.deck.add(card);
            }
        }
    }
    
    public int getSize(){
        return deck.size();
    }

    
    public void shuffle(){
        Random random = new Random();
        int sizeOfDeck = deck.size();
        for(int i = 0; i < sizeOfDeck; ++i){
            int position = random.nextInt(40);
            PlayerCard cardAtI = deck.get(i);
            PlayerCard cardAtRandom = deck.get(position);
            deck.set(position, cardAtI);
            deck.set(i, cardAtRandom);
        }
    }
    
    public PlayerCard get(int index){//gets card at index
        return deck.get(index);
    }
    
    public PlayerCard pop(){//returns and takes off the top card of the deck
                            //can return null if you run out of cards in the deck
        if(deck.isEmpty()){
            return null;
        }
        PlayerCard card = deck.remove(deck.size() - 1);
        card.unsetLocation();
        return card;
    }
}
