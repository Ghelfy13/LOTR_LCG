/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Enemy;
import lordoftherings.characters.GameCharacter;
import lordoftherings.effects.PlayToQuickStrikeEffect.ResultList;

/**
 *
 * @author Amanda
 */
public class PlayToQuickStrikeResultHandler implements ResultHandler<ArrayList<GameCharacter>>{

    private Board board;
    private ResultList list;
    
    public PlayToQuickStrikeResultHandler(Board board, ResultList list){
        this.board = board;
        this.list = list;
    }
    
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        list.addCharsToExhaust(result);
        board.getEnemyToAttack(new ArrayList<Enemy>(), list);
        board.removeRecentSuspension();
    }
    
}
