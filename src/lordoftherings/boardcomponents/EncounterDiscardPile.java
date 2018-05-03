//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.cards.EncounterCard;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardPile {
    private ArrayList<EncounterCard> discardPile;
    private int ownerID = -5;
    
    public EncounterDiscardPile(){
        discardPile = new ArrayList<>();
    }
    
    public int getOwnerID(){
        return ownerID;
    }
    
    public void addCardToPile(EncounterCard discardedCard){
        discardPile.add(discardedCard);
    }
    
    public EncounterCard getTopCard(){
        if(discardPile.size() != 0){
            return discardPile.get(discardPile.size() -1);
        }
        return null;
    }
    
    public int getSize(){
        return discardPile.size();
    }
    
    public EncounterCard removeCard(EncounterCard card){
        discardPile.remove(card);
        return card;
    }
    
    public EncounterCard removeCardAt(int index){
        EncounterCard card = discardPile.get(index);
        discardPile.remove(card);
        return card;
    }
    
    public int findCard(EncounterCard card){
        return discardPile.indexOf(card);
    }
    
}
