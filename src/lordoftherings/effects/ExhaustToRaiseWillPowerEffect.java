//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.AllyCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.matcher.PlayerZoneMatcher;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.PlayerQueryHandle;
import lordoftherings.transaction_managers.PlayerQueryRequirements;

/**
 *
 * @author Amanda
 */
public class ExhaustToRaiseWillPowerEffect implements Effect{

    private int numOfWill = 0;
    
    public ExhaustToRaiseWillPowerEffect(int num){
        numOfWill = num;
    }
    
    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        AllyCard myAlly = (AllyCard) card;
        PlayerZoneMatcher desiredPlayerZone = new PlayerZoneMatcher();
        PlayerQueryRequirements requirements = new PlayerQueryRequirements(
            desiredPlayerZone, 1, 1);
        board.handlePlayerZoneQuery( new PlayerQueryHandle(requirements,
            new ExhaustToRaiseWillPowerHandler(board, myAlly),
            new ClearSuspensionHandler(board)),
            "Choose a player to have all their character's"
                    + " will power raised by " + numOfWill);
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
        }else if(card.getLocation() == LocationOnBoard.HAND &&
                board.getPhaseManagerGovenor().isCurrentPhaseActionable()){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
