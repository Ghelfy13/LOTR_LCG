//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Ally;
import lordoftherings.characters.GameCharacter;
import lordoftherings.characters.Hero;

/**
 *
 * @author Amanda
 */
public class ExhaustToHealHandler implements ResultHandler<ArrayList<GameCharacter>>{
    
    private Board board;
    private Ally healer;
    private int healingPower;
    
    public ExhaustToHealHandler(Board board, Ally healer, int healingPower){
        this.board = board;
        this.healer = healer;
        this.healingPower = healingPower;
    }

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        Hero damagedHero = (Hero) result.get(0);
        damagedHero.removeDamage(healingPower);
        healer.exhaust();
        board.removeRecentSuspension();
    }
    
}
