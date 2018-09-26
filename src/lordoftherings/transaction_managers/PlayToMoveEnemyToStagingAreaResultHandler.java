//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.boardcomponents.PlayerZone;
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
        EncounterZone encounterZone = board.getEncounterZone();
        for(int i = 0; i < result.size(); ++i){
            Enemy current = result.get(i);
            PlayerZone zone = board.getPlayerZoneAt(current.getCard().getControllerID());
            zone.getEngagementArea().removeEnemy(current);
            encounterZone.getStagingArea().getEnemyArea().addEnemyToList(current);
            current.getCard().setLocation(LocationOnBoard.ENCOUNTER_ZONE, -1);
        }
        board.getCurrentPlayerZone().getHand().removeCard(event);
        board.getCurrentPlayerZone().moveCardToDiscardPile(event);
    }

}
