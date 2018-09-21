//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.EventCard;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class PlayToMoveEnemyToStagingAreaResultHandler implements ResultHandler<ArrayList<Enemy>>{
    
    private Board board;
    private EventCard event;

    public PlayToMoveEnemyToStagingAreaResultHandler(Board board, EventCard card){
        this.board = board;
        this.event = card;
    }
    
    @Override
    public void handle(ArrayList<Enemy> result) {
        board.moveEnemiesToStagingArea(result);
        board.removeRecentSuspension();
    }

}
