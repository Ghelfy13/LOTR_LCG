//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;

/**
 *
 * @author Amanda
 */
public class PlayGrimResolveEffect implements Effect{
    
    
    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        board.readyAllCharacters();
        PlayerZone controller = board.getPlayerZoneAt(event.getController());
        controller.payForCard(event.getCost());
        controller.moveCardToDiscardPile(event);
        controller.getHand().removeCard(event);
        board.removeRecentSuspension();
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
         EventCard event = (EventCard) card;
        if(event.getController() == askingID && 
                board.getPhaseManagerGovenor().isCurrentPhaseActionable()&&
                board.getCurrentPlayerZone().getHerosResources()>= event.getCost() &&
                event.getLocation() == LocationOnBoard.HAND){
            return ActionState.EXECUTABLE;
        }else if(event.getController() == askingID && 
                board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
                event.getLocation() == LocationOnBoard.HAND){
            return ActionState.VISIBLE;
        }else{
            return ActionState.NOTAVAILABLE;
        }
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "After playing, ready all character cards in play.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
