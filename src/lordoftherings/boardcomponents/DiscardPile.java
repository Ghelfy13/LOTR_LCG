//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.cards.PlayerCard;
/**
 *
 * @author Amanda
 */
public class DiscardPile {
    private ArrayList <PlayerCard> dPile;
    private int ownerID;
    
    public DiscardPile(int ownerID){
        dPile = new ArrayList<>();
        this.ownerID = ownerID;
    }
    
    public void addCard(PlayerCard card){
        dPile.add(card);
    }
    
    public PlayerCard getTopCard(){
        if(dPile.size() != 0){
            return dPile.get(dPile.size() -1);
        }
        return null;
    }
    
    public int getSize(){
        return dPile.size();
    }
    
    public PlayerCard returnCard(PlayerCard card){
        dPile.remove(card);
        return card;
    }
    
    public PlayerCard returnCardAt(int index){
        PlayerCard card = dPile.get(index);
        dPile.remove(index);
        return card;
    }
    
    public int findCard(PlayerCard card){//can return -1 if card not found
        return dPile.indexOf(card);
        //TODO: OTHER FIND METHODS WILL BE IN A CLASS CALLED "MATCH"
    }
}
