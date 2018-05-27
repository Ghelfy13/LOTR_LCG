//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Ally;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class ExhaustToHealHandler implements ResultHandler<ArrayList<GameCharacter>>{
    
    private Board board;
    private Ally healer;
    
    public ExhaustToHealHandler(Board board, Ally healer){
        this.board = board;
        this.healer = healer;
    }

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
