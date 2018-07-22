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
public class DiscardToDrawCardsHandler implements ResultHandler<ArrayList<PlayerZone>>{
    private Board board;
    private EventCard card;
    private int numOfCards;
    
    public DiscardToDrawCardsHandler(Board board, EventCard card, int num){
        this.board = board;
        this.card = card;
        this.numOfCards = num;
    }
    
    @Override
    public void handle(ArrayList<PlayerZone> result) {
        for(int i = 0; i < result.size(); ++i){
            for(int j = 0; j < numOfCards; ++j){
                result.get(i).drawCardFromDeckAddToHand();
            }
        }
        board.removeRecentSuspension();
    }
    
}
