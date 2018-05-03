//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.AvailableActionsView;
import lordoftherings.manager.BoardControllerComponents.BoardViewController;


/**
 *
 * @author Amanda
 */
public class BoardActiveState extends FocusableActiveState {
    private BoardViewController boardVC;
    private Actionable currentActionable;
    private AvailableActionsViewController availableActionsVC;
    private AvailableActionsView actionsView;
    public static final Border ACTIVE_BORDER = BorderFactory.createMatteBorder(5,5,5,5,Color.YELLOW);
    public static final Border INACTIVE_BORDER = BorderFactory.createEmptyBorder();
    
    public BoardActiveState(BoardViewController boardVC) {
        super(boardVC);
        this.boardVC = boardVC;
        currentActionable = null;
        availableActionsVC = new AvailableActionsViewController(this);
        actionsView = availableActionsVC.makeView(2250, 100);
    }
    
    public void setActionable(Actionable newActionable){
        if(currentActionable == newActionable) return;
        unsetActionable();
        currentActionable = newActionable;
        currentActionable.onSetActionable();
        actionsView = availableActionsVC.updateView(2250, 100);
    }
    
    public void unsetActionable(){
        if(currentActionable == null) return;
        currentActionable.onUnsetActionable();
        currentActionable = null;
        actionsView = availableActionsVC.updateView(2250, 100);
    }
    
    public AvailableActionsView getAvailableActions(){
        return actionsView;
    }
    
    public Actionable getCurrentActionable(){
        return currentActionable;
    }
    
    public Board getBoard(){
        return boardVC.getBoard();
    }

    public void executeAction(Action desiredAction) {
        if(!desiredAction.isExecutable()){
            return;
        }
        desiredAction.execute(0, boardVC.getBoard());
        unsetFocusable(getCurrentFocusable());
        boardVC.updateView();
    }
}
