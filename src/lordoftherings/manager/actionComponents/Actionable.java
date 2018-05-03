//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.util.ArrayList;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public interface Actionable extends Focusable{
    void onSetActionable();
    void onUnsetActionable();
    void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState);
}
