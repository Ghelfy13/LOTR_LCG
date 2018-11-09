//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.EventCard;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class PlayToFeintResultHandler implements ResultHandler<ArrayList<Enemy>>{
    private EventCard event;
    private Board board;
    
    public PlayToFeintResultHandler(EventCard event, Board board){
        this.event = event;
        this.board = board;
    }
    
    @Override
    public void handle(ArrayList<Enemy> result) {
        for(int i = 0; i < result.size(); ++i){
            Enemy current = result.get(i);
            current.setEnemyToNotAttacking();
        }
        PlayerZone zone = board.getPlayerZoneAt(event.getController());
        zone.payForCard(event.getCost());
        zone.moveCardToDiscardPile(event);
        zone.getHand().removeCard(event);
    }
    
}
