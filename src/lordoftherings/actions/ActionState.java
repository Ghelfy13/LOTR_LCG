//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.boardcomponents.Board;
import lordoftherings.phasemanager.GamePhase;

/**
 * {@link ActionState} refers to the status of any individual {@link Action}
 * given the current state of the {@link Board} and the current player id making
 * the request.
 *
 * @author Amanda
 */
public enum  ActionState {
    /**
     * Refers to when an action can be played during the current
     * {@link GamePhase} and all associated costs can be met.
     * 
     * <p> Costs may include needed to exhaust a character, needing more
     * resources, or needing at least one enemy in the staging area, etc.
     */
    EXECUTABLE,
    
    /**
     * Refers to when an {@link Action} can be played during the current
     * {@link GamePhase}, but some costs cannot be met or valid targets for the
     * action cannot be found.
     * 
     * <p> Visible Actions should appear on the {@link Board} but should not be
     * executed. Allowing the player to see when actions can occur.
     * 
     * <p> NOTE: this could be expanded in the future to multiple enumerations
     * to specify which requirement has not been met.
     */
    VISIBLE,
    
    /**
     * Refers to when {@link Action} is not available during the current
     * {@link GamePhase} or if the {@link Board} is suspended.
     *
     * <p> Currently {@link Board} suspensions that are actionable, such as
     * resolving Enemy attacks, are presently not supported. 
     */
    NOTAVAILABLE
}
