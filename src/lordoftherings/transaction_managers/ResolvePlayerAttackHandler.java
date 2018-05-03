//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Enemy;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class ResolvePlayerAttackHandler implements ResultHandler<ArrayList<GameCharacter>>{
    private Enemy target;
    private Board board;
    
    public ResolvePlayerAttackHandler(Enemy target, Board board){
        this.target = target;
        this.board = board;
    }

      
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        board.resolveAttackOnEnemy(target, result);
    }
    
}
