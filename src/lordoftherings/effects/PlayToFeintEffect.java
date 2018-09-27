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
import lordoftherings.matcher.EngagedEnemyMatcher;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.EnemyQueryHandle;
import lordoftherings.transaction_managers.EnemyQueryRequirements;
import lordoftherings.transaction_managers.PlayToFeintResultHandler;

/**
 *
 * @author Amanda
 */
public class PlayToFeintEffect implements Effect{

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        EngagedEnemyMatcher engagedEnemy = new EngagedEnemyMatcher();
        EnemyQueryRequirements requirements = 
                new EnemyQueryRequirements(engagedEnemy, 1, 1);
        board.handleEnemyQuery(new EnemyQueryHandle(
            requirements,
            new PlayToFeintResultHandler(event, board),
            new ClearSuspensionHandler(board)),
            "Choose an engaged enemy so that they can not attack this phase.");
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
        return "Play and choose any engaged enemy so that they can't attack this phase";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
