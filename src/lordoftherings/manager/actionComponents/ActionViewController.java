//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import lordoftherings.actions.Action;
import lordoftherings.gui.ActionView;

/**
 *
 * @author Amanda
 */
public class ActionViewController implements Focusable {
    private ActionView view;
    private AvailableActionsViewController aaVC;
    private Action wantedAction;
    private BoardActiveState boardAS;
    
    public ActionViewController(Action newAction, AvailableActionsViewController aaVC){
        this.wantedAction = newAction;
        this.aaVC = aaVC;
        this.boardAS = aaVC.getBAS();
    }
    
    public ActionView makeView(int x, int y){
        view = new ActionView(boardAS, this, wantedAction, x, y);
        view.setVisible(true);
        return view;
    }

    @Override
    public String getViewingText() {
        return wantedAction.getDescription();
    }
    
    public BoardActiveState getBAS(){
        return aaVC.getBAS();
    }
}
