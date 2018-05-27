//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public abstract class Action {
    protected String description;//OfAction
    protected ActionState state;
    //protected so that you can access in subClasses
    
    public Action(String description){
        this.description = description;
        state = ActionState.NOTAVAILABLE;
    }
    
    public boolean isAvailable(){
        return (state == ActionState.EXECUTABLE || state == ActionState.VISIBLE);
    }
    
    public boolean isExecutable(){
        return state == ActionState.EXECUTABLE;
    }
    
    public abstract boolean execute(int askingID, Board boardState);
    public abstract void updateActionState(int askingID, Board boardState);

    public String getDescription() {
        return description;
    }
    
}
