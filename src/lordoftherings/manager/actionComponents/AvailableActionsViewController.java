//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.util.ArrayList;
import lordoftherings.GameConfiguration;
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
    private GameConfiguration config;
    public static final int X_VALUE = 40;
    public static final int EMPTY_BOX_SIZE = ActionView.BOX_DIMENSIONS + 10;
    
    public AvailableActionsViewController(BoardActiveState boardAS, GameConfiguration config){
        //TODO: FINISH
        this.listOfActions = new ArrayList<>();
        this.boardAS = boardAS;
        this.view = null;
        this.config = config;
    }
    
    public AvailableActionsView makeView(int x, int y){
        view = new AvailableActionsView(x, y, 1, config);
        updateView(x, y);
        return view;
    }
    
    public AvailableActionsView updateView(int x, int y){//DON'T SCALE THE X AND Y HERE.  IT IS TAKEN FROM LOCATION ON SCREEN
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
            if(listOfActions.isEmpty()){
                view.setBounds(config.scale(x), config.scale(y), 
                        config.scale(EMPTY_BOX_SIZE), config.scale(EMPTY_BOX_SIZE));
            }else{
                view.setBounds(x, y,
                        (ActionView.BOX_DIMENSIONS +5)*listOfActions.size() +5,
                        EMPTY_BOX_SIZE);
            }
            for(int i = 0; i < listOfActions.size(); ++i){
                Action currentAction = listOfActions.get(i);
                ActionViewController actionVC = new ActionViewController(currentAction, this, config);
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
