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
import lordoftherings.characters.Enemy;
import lordoftherings.matcher.EngagedEnemyMatcher;
import lordoftherings.matcher.Matcher;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.EnemyQueryHandle;
import lordoftherings.transaction_managers.EnemyQueryRequirements;
import lordoftherings.transaction_managers.PlayToMoveEnemyToStagingAreaResultHandler;

/**
 *
 * @author Amanda
 */
public class PlayToMoveEnemyToStagingAreaEffect implements Effect{

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        Matcher<Enemy> engagedEnemyMatcher = new EngagedEnemyMatcher();
        EnemyQueryRequirements requirements = new EnemyQueryRequirements(
            engagedEnemyMatcher, 1, 1);
        board.handleEnemyQuery(new EnemyQueryHandle(requirements,
            new PlayToMoveEnemyToStagingAreaResultHandler(board, event),
            new ClearSuspensionHandler(board)),
            "Choose an enemy engaged with a play to move them back into the staging area.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        if(askingID == card.getOwner() && 
                board.getCurrentPlayerZone().getHerosResources() >= card.getCost() &&
                card.getLocation() == LocationOnBoard.HAND &&
                board.getCurrentPlayerNum() == card.getOwner()&&
                board.getPhaseManagerGovenor().isCurrentPhaseActionable()){
            return ActionState.EXECUTABLE;
        }else if(askingID == card.getOwner() && 
                card.getLocation() == LocationOnBoard.HAND &&
                board.getCurrentPlayerNum() == card.getOwner()){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Play " + card.getTitle() + " to select and move an enemy engaged with a player to the staging area.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
