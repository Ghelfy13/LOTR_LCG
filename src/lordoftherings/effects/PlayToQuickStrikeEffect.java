//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;

/**
 *
 * @author Amanda
 */
public class PlayToQuickStrikeEffect implements Effect{

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "Play to exhaust a character you control to immediate attack any chosen enemy egaged with you.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
