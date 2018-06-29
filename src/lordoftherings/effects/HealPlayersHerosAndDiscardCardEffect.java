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
import lordoftherings.transaction_managers.DiscardToHealPlayersHerosResultHandler;
import lordoftherings.transaction_managers.PlayerZoneQueryHandle;
import lordoftherings.transaction_managers.PlayerZoneQueryRequirements;

/**
 *
 * @author Amanda
 */
public class HealPlayersHerosAndDiscardCardEffect implements Effect{
    
    public HealPlayersHerosAndDiscardCardEffect(){}

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        PlayerZoneMatcher desiredPlayerZone = new PlayerZoneMatcher();
        PlayerZoneQueryRequirements requirements = new PlayerZoneQueryRequirements
            (desiredPlayerZone, 1, 1);
        board.handlePlayerZoneQuery( 
            new PlayerZoneQueryHandle(requirements,
            new DiscardToHealPlayersHerosResultHandler(board, event),
            new ClearSuspensionHandler(board)), 
            "Choose a player to heal all of their heros.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        PlayerZone zone = board.getPlayerZoneAt(card.getController());
        if(askingID == card.getController() && 
            card.getLocation() == LocationOnBoard.HAND && 
            board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
            zone.getHerosResources() >= card.getCost()){
            return ActionState.EXECUTABLE;
        }else if(card.getLocation() == LocationOnBoard.HAND){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Play this card to heal all heros on a chosen players field.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
