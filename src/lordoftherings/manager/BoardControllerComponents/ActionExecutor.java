//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lordoftherings.actions.Action;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class ActionExecutor implements ActionListener {
    private BoardActiveState boardAS;
    private Action desiredAction;
    
    public ActionExecutor(BoardActiveState boardAS, Action desiredAction){
        this.boardAS = boardAS;
        this.desiredAction = desiredAction;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boardAS.executeAction(desiredAction);
    }
    
}
