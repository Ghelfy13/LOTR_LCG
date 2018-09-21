//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.GameCharacter;
import lordoftherings.effects.DiscardToExhaustAndReadyEffect.ResultList;

/**
 *
 * @author Amanda
 */
public class DiscardToExhaustAndReadyResultHandler implements ResultHandler<ArrayList<GameCharacter>>{

    private Board board;
    private ResultList list;
    
    public DiscardToExhaustAndReadyResultHandler(Board board, ResultList list){
        this.board = board;
        this.list = list;
    }
    
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        list.addCharsToExhaust(result);
        board.getCharactersToReady(new ArrayList<GameCharacter>(), list);
        board.removeRecentSuspension();
        
    }

    
}
