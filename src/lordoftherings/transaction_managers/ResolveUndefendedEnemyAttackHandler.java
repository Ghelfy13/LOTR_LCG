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
public class ResolveUndefendedEnemyAttackHandler implements ResultHandler<ArrayList<GameCharacter>>{

    Enemy attacker;
    Board board;
    
    public ResolveUndefendedEnemyAttackHandler(Enemy attacker, Board board){
        this.attacker = attacker;
        this.board = board;
    }
    
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        board.resolveAttackWithNoDefenders(attacker, result);
    }
    
}
