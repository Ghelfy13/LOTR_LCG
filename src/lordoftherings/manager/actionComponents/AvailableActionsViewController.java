//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.util.ArrayList;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.ActionView;
import lordoftherings.gui.AvailableActionsView;

/**
 *
 * @author Amanda
 */
public class AvailableActionsViewController{
 
    //Need knowledge of location, and list of actions
    private ArrayList<Action> listOfActions;
    private AvailableActionsView view;
    private BoardActiveState boardAS;
    public static final int EMPTY_BOX_SIZE = ActionView.BOX_DIMENSIONS + scale(10);
    public static final int X_VALUE = 40;
    
    public AvailableActionsViewController(BoardActiveState boardAS){
        //TODO: FINISH
        this.listOfActions = new ArrayList<>();
        this.boardAS = boardAS;
        this.view = null;
    }
    
    public AvailableActionsView makeView(int x, int y){
        view = new AvailableActionsView(x, y, 1);
        updateView(x, y);
        return view;
    }
    
    public AvailableActionsView updateView(int x, int y){//DON'T SCALE THE X AND Y HERE.  IT IS TAKEN FROM LOCATION ON SCREEN
        Actionable currentActionable = boardAS.getCurrentActionable();
        int yCoordinate = 0;
        if(currentActionable != null){
            yCoordinate = scale(currentActionable.getActionsYCoordinate());
        }
        view.setLocation(x, y);
        if(currentActionable == null){
            listOfActions.clear();
            view.removeAll();
            view.setVisible(false);
            return view;
        }else{
            Board boardState = boardAS.getBoard();
            listOfActions.clear();
            currentActionable.getActions(listOfActions, 0, boardState);
            if(listOfActions.isEmpty()){
                view.setBounds(x, y, 
                        EMPTY_BOX_SIZE, EMPTY_BOX_SIZE);
            }else{
                view.setBounds(x, y,
                        (ActionView.BOX_DIMENSIONS +scale(5))*listOfActions.size() +scale(5),
                        EMPTY_BOX_SIZE);
            }
            for(int i = 0; i < listOfActions.size(); ++i){
                Action currentAction = listOfActions.get(i);
                ActionViewController actionVC = new ActionViewController(currentAction, this);
                int calculatedX = 5;
                int calculatedY = 5;
                ActionView actionV = actionVC.makeView(calculatedX*(i+1)+
                        X_VALUE*(i), calculatedY);
                view.add(actionV);
                actionV.setVisible(true);
            }
                           
            view.setVisible(true);
            return view;
        }
    }

    public BoardActiveState getBAS(){
        return boardAS;
    }
}
