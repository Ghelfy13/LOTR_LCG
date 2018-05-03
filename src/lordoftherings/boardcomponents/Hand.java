//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.cards.PlayerCard;
import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
/**
 *
 * @author Amanda
 */
public class Hand {
    private ArrayList <PlayerCard> hand;
    private int ownerID;
    
    public Hand(int ownerID){
        this.hand = new ArrayList<>(5);
        this.ownerID = ownerID;
    }
    
    public void addCard(PlayerCard card){
        hand.add(card);
        card.setLocation(ownerID, LocationOnBoard.HAND);
    }
    
    public PlayerCard removeCard(PlayerCard myCard){//can return null if card doesn't exist
        if(findCard(myCard)!=-1){
            hand.remove(myCard);
            myCard.unsetLocation();
            return myCard; 
        }else{
            return null;
        }
    }
    
    public int getOwnerID(){
        return ownerID;
    }
    
    public PlayerCard removeCardAt(int index){
        PlayerCard myCard = getCardAt(index);
        hand.remove(index);
        return myCard;
    }
    
    public int findCard(PlayerCard myCard){//naturally returns -1 if card is not in hand
       return hand.indexOf(myCard);
    }
    
    public int getSizeOfHand(){
        return hand.size();
    }
    
    public PlayerCard getCardAt(int index){
        return hand.get(index);
    }
    
    public ArrayList<PlayerCard> getHand(){
        return hand;
    }
}
