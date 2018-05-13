//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.LocationCard;

/**
 *
 * @author Amanda
 */
public class Location {
    private int numOfTokens;
    private LocationCard card;
    
    public Location(LocationCard card){
        this.card = card;
        this.numOfTokens = 0;
    }
    
    public int getNumOfTokens(){
        return numOfTokens;
    }
    
    public LocationOnBoard getLocationOnBoard(){
        return card.getLocation();
    }
    
    public int getThreat(){
        return card.getModel().getThreat();
    }
    
    public void setLocationOnBoard(LocationOnBoard newBoardLocation){
       card.setLocation(newBoardLocation, -5);
    }
    
    public void addTokens(int num){
        numOfTokens += num;
    }
    
    public void takeAwayTokens(int num){
        numOfTokens -= num;
    }
    
    public LocationCard getCard(){
        return card;
    }
    
    public void getActions(ArrayList<Action> listOfActions, Board board, int askingID){
        card.getActions(listOfActions, board, askingID);
    }
            
}
