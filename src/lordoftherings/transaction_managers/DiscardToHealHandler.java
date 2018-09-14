//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DiscardToHealHandler implements ResultHandler<ArrayList<GameCharacter>>{
    private PlayerCard healingCard;
    private Board board;
    
    public DiscardToHealHandler(PlayerCard card, Board board){
        healingCard = card;
        this.board = board;
    }
    
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        for(int i = 0; i < result.size(); ++i){
            result.get(i).removeDamage(result.get(i).getDamage());
        }
        PlayerZone zone = board.getPlayerZoneAt(healingCard.getController());
        zone.moveCardToDiscardPile(healingCard);
        zone.getHand().removeCard(healingCard);
    }
    
}
