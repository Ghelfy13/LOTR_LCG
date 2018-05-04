//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import lordoftherings.LocationOnBoard;
import lordoftherings.cards.LocationCard;

/**
 *
 * @author Amanda
 */
public class Location {
    private int numOfTokens;
    private LocationCard card;
    private LocationOnBoard whereOnBoard = LocationOnBoard.UNSET;
    
    public Location(LocationCard card){
        this.card = card;
        this.numOfTokens = 0;
    }
    
    public int getNumOfTokens(){
        return numOfTokens;
    }
    
    public LocationOnBoard getLocationOnBoard(){
        return whereOnBoard;
    }
    
    public void setLocationOnBoard(LocationOnBoard newBoardLocation){
        whereOnBoard = newBoardLocation;
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
            
}
