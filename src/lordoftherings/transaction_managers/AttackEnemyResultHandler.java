/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Enemy;
import lordoftherings.effects.PlayToQuickStrikeEffect.ResultList;

/**
 *
 * @author Amanda
 */
public class AttackEnemyResultHandler implements ResultHandler<ArrayList<Enemy>> {
    
    private Board board;
    private ResultList list;
    
    public AttackEnemyResultHandler(Board board, ResultList list){
        this.board = board;
        this.list = list;
    }

    @Override
    public void handle(ArrayList<Enemy> result) {
        list.addEnemyToAttack(result);
        list.executeActions();
    }
    
}
