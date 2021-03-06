//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.AllyCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.Ally;
import lordoftherings.matcher.AnyMatcher;
import lordoftherings.modifiers.Modifier;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.ExhaustToRaiseWillPowerHandler;
import lordoftherings.transaction_managers.PlayerQueryHandle;
import lordoftherings.transaction_managers.PlayerQueryRequirements;

/**
 *
 * @author Amanda
 */
public class ExhaustToRaiseWillPowerEffect implements Effect{

    private int numOfWill = 0;
    private Modifier mod;
    
    public ExhaustToRaiseWillPowerEffect(int num, Modifier mod){
        numOfWill = num;
        this.mod = mod;
    }
    
    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        AllyCard myAlly = (AllyCard) card;
        AnyMatcher<PlayerZone> desiredPlayerZone = new AnyMatcher<>();
        PlayerQueryRequirements requirements = new PlayerQueryRequirements(
            desiredPlayerZone, 1, 1);
        board.handlePlayerZoneQuery( new PlayerQueryHandle(requirements,
            new ExhaustToRaiseWillPowerHandler(board, myAlly, mod),
            new ClearSuspensionHandler(board)),
            "Choose a player to have all their character's"
                    + " will power raised by " + numOfWill);
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        PlayerZone zone = board.getPlayerZoneAt(card.getController());
        AllyCard myAlly = (AllyCard) card;
        Ally ally = board.getCurrentPlayerZone().getCharZone().findAlly(myAlly);
        if(askingID == card.getController() && 
            card.getLocation() == LocationOnBoard.FIELD && 
            !ally.isExhausted()&&
            board.getPhaseManagerGovenor().isCurrentPhaseActionable()){
            return ActionState.EXECUTABLE;
        }else if(card.getLocation() == LocationOnBoard.FIELD &&
                board.getPhaseManagerGovenor().isCurrentPhaseActionable()){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Exhaust card and choose a player to raise all of their characters will by " + numOfWill;
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card,this);
    }
    
}
