//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.GameCharacter;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class ResolveEnemyAttackHandler implements ResultHandler<ArrayList<GameCharacter>>{
    private Enemy attacker;
    private Board board;
    
    public ResolveEnemyAttackHandler(Enemy attacker, Board board){
        this.attacker = attacker;
        this.board = board;
    }

    
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        board.resolveAttackWithDefenders(attacker, result);
        
    }
    
    
}
