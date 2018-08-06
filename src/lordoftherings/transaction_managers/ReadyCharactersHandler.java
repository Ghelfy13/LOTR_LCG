//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class ReadyCharactersHandler implements ResultHandler<ArrayList<GameCharacter>> {
    
    private Board board;
    
    public ReadyCharactersHandler(Board board){
        this.board = board;
    }

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        for(int i = 0; i < result.size(); ++i){
            result.get(i).ready();
        }
    }

}
