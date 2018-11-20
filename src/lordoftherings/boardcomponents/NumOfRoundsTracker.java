//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsTracker {
    private Board board;
    private int numOfRounds;
    
    public NumOfRoundsTracker(Board board){
        this.board = board;
        this.numOfRounds = 1;
    }
    
    public int getNumOfRounds(){
        return numOfRounds;
    }
    
    public void raiseRoundCounter(){
        ++numOfRounds;
    }
}
