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
public class DiscardToDrawHandler implements ResultHandler<ArrayList<PlayerZone>>{
    private Board board;
    private EventCard card;
    private int numOfCards;
    
    public DiscardToDrawHandler(Board board, EventCard card, int num){
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
        PlayerZone controller = board.getPlayerZoneAt(card.getController());
        controller.payForCard(card.getCost());
        controller.getHand().removeCard(card);
        controller.getDPile().addCard(card);
        board.removeRecentSuspension();
    }
    
}
