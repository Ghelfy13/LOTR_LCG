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
public class ReadyCharactersHandler implements ResultHandler<ArrayList<GameCharacter>> {
    
    private Board board;
    private ResultList list;
    
    public ReadyCharactersHandler(Board board, ResultList list){
        this.board = board;
        this.list = list;
    }

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        list.addCharsToReady(result);
        list.executeActions();
    }

}
