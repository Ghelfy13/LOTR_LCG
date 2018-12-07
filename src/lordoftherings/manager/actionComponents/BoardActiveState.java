//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.Color;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import lordoftherings.GameConfiguration;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.AvailableActionsView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;


/**
 *
 * @author Amanda
 */
public class BoardActiveState extends FocusableActiveState {
    private GameManagerViewController gameManagerVC;
    private Actionable currentActionable;
    private AvailableActionsViewController availableActionsVC;
    private AvailableActionsView actionsView;
    public static final Border ACTIVE_BORDER = BorderFactory.createMatteBorder(5,5,5,5,Color.YELLOW);
    public static final Border INACTIVE_BORDER = BorderFactory.createEmptyBorder();
    
    public BoardActiveState(GameManagerViewController gameManagerVC, GameConfiguration config) {
        super(gameManagerVC);
        this.gameManagerVC = gameManagerVC;
        currentActionable = null;
        availableActionsVC = new AvailableActionsViewController(this, config);
        actionsView = availableActionsVC.makeView(2250, 100);
    }
    
    public void setActionable(Actionable newActionable){
        if(currentActionable == newActionable) return;
        unsetActionable();
        currentActionable = newActionable;
        currentActionable.onSetActionable();
        Point locationOnScreen = currentActionable.getView().getLocationOnScreen();
        Point gameManagerLocation = gameManagerVC.getView().getLocationOnScreen();
        Point difference = new Point(locationOnScreen.x - gameManagerLocation.x, locationOnScreen.y - gameManagerLocation.y);
        actionsView = availableActionsVC.updateView(difference.x, difference.y);
    }
    
    public void unsetActionable(){
        if(currentActionable == null) return;
        Point locationOnScreen = currentActionable.getView().getLocationOnScreen();
        currentActionable.onUnsetActionable();
        currentActionable = null;
        actionsView = availableActionsVC.updateView(locationOnScreen.x, locationOnScreen.y);
    }
    
    public AvailableActionsView getAvailableActions(){
        return actionsView;
    }
    
    public Actionable getCurrentActionable(){
        return currentActionable;
    }
    
    public Board getBoard(){
        return gameManagerVC.getBoard();
    }

    public void executeAction(Action desiredAction) {
        if(!desiredAction.isExecutable()){
            return;
        }
        desiredAction.execute(0, gameManagerVC.getBoard());
        unsetFocusable(getCurrentFocusable());
        gameManagerVC.updateView();
    }
}
