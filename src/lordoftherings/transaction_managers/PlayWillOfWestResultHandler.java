//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.EventCard;

/**
 *
 * @author Amanda
 */
public class PlayWillOfWestResultHandler implements ResultHandler<ArrayList<PlayerZone>> {
    
    private Board board;
    private EventCard card;
    
    public PlayWillOfWestResultHandler(Board board, EventCard card){
        this.board = board;
        this.card = card;
    }

    @Override
    public void handle(ArrayList<PlayerZone> result) {
        for(int i = 0; i < result.size(); ++i){
            PlayerZone current = result.get(i);
            current.reshuffleDiscardPile();
        }
        PlayerZone controller = board.getPlayerZoneAt(card.getController());
        controller.payForCard(card.getCost());
        controller.moveCardToDiscardPile(card);
        controller.getHand().removeCard(card);
        board.removeRecentSuspension();
        
    }
    
}
