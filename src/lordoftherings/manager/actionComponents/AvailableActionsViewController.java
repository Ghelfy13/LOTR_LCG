//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.util.ArrayList;
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
    
    public AvailableActionsViewController(BoardActiveState boardAS){
        //TODO: FINISH
        this.listOfActions = new ArrayList<>();
        this.boardAS = boardAS;
        this.view = null;
    }
    
    public AvailableActionsView makeView(int x, int y){
        view = new AvailableActionsView(x, y);
        updateView(x, y);
        return view;
    }
    
    public AvailableActionsView updateView(int x, int y){
        Actionable currentActionable = boardAS.getCurrentActionable();
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
            
            for(int i = 0; i < listOfActions.size(); ++i){
                Action currentAction = listOfActions.get(i);
                ActionViewController actionVC = new ActionViewController(currentAction, this);
                int calculatedX = 25;
                int calculatedY = 25;
                ActionView actionV = actionVC.makeView(calculatedX, calculatedY);
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
