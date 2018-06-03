//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.EventCard;
import lordoftherings.characters.Ally;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DiscardToReadyHandler implements ResultHandler<ArrayList<GameCharacter>>{
    
    private Board board;
    private EventCard card;
    
    public DiscardToReadyHandler(Board board, EventCard card){
        this.board = board;
        this.card = card;
    }

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        for(int i = 0; i < result.size(); ++i){
            Ally current = (Ally) result.get(i);
            current.ready();
        }
        PlayerZone playerZone = board.getPlayerZoneAt(card.getController());
        playerZone.moveCardToDiscardPile(card);
        playerZone.getHand().removeCard(card);
        board.removeRecentSuspension();
        
    }
    
}
