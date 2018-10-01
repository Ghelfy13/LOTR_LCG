//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.matcher.NonEngagedEnemyMatcher;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.EnemyQueryHandle;
import lordoftherings.transaction_managers.EnemyQueryRequirements;
import lordoftherings.transaction_managers.PlayRadagastsCunningResultHandler;

/**
 *
 * @author Amanda
 */
public class PlayRadagastsCunningEffect implements Effect{

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        NonEngagedEnemyMatcher nonEngagedMatcher = new NonEngagedEnemyMatcher();
        EnemyQueryRequirements requirements = 
                new EnemyQueryRequirements(nonEngagedMatcher, 1,1);
        board.handleEnemyQuery( new EnemyQueryHandle(   
            requirements,
            new PlayRadagastsCunningResultHandler(event, board),
            new ClearSuspensionHandler(board)),
            "Choose an enemy in the staging area, and for that phase that "
                    + "enemies threat does not contribute to the total threat cound.");
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
        return "Play to select and enemy in the staging area.  For this phase, "
                + "that enemy's threat does not contribute to the total threat.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
