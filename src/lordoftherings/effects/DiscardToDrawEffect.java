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
import lordoftherings.matcher.PlayerZoneMatcher;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.PlayerQueryHandle;
import lordoftherings.transaction_managers.PlayerQueryRequirements;

/**
 *
 * @author Amanda
 */
public class DiscardToDrawEffect implements Effect{
    
    private int drawValue = 0;
    
    public DiscardToDrawEffect(int num){
        drawValue = num;
    }

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        PlayerZoneMatcher desiredPlayerZone = new PlayerZoneMatcher();
        PlayerQueryRequirements requirements = new PlayerQueryRequirements(
            desiredPlayerZone, 1, 1);
        board.handlePlayerZoneQuery(new PlayerQueryHandle(requirements, 
            new DiscardToDrawCardsHandler(board, event),
            new ClearSuspensionHandler(board)),
            "Choose a player to draw " + drawValue + " cards.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        PlayerZone zone = board.getCurrentPlayerZone();
        if(askingID == card.getOwner() && board.getCurrentPlayerNum() == card.getOwner() &&
                zone.getHerosResources() >= card.getCost() && board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
                card.getLocation() == LocationOnBoard.HAND){
            return ActionState.EXECUTABLE;
        }else if(askingID == card.getOwner() && board.getCurrentPlayerNum() == card.getOwner() &&
                card.getLocation() == LocationOnBoard.HAND){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Discard " + card.getTitle() + " to draw " + drawValue + " cards.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
