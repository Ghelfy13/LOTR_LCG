//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.actions.ActionState;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.PlayerCard;

/**
 *
 * @author Amanda
 */
public interface Effect {
    
    boolean execute(int askingID, Board board, PlayerCard card);
    ActionState getCurrentState(
            int askingID, Board board, PlayerCard card);
    String createDescription(PlayerCard card);
    EffectAction getAction(PlayerCard card);
}
