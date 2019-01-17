//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.game_engine;


/**
 *
 * @author Amanda
 */
public abstract class GameState {
    
    public State currentState;
    
    public GameState(){
        currentState = State.INACTIVE;
    }
    
    public void onCreate(GameEngine engine){
        if(currentState == State.INACTIVE){
            currentState = State.IDLE;
        }else{
            throw new IllegalStateException("In the wrong state for this action.");
        }
    }
    
    public void onResume(GameEngine engine){
        if(currentState == State.IDLE){
            currentState = State.ACTIVE;
        }else{
            throw new IllegalStateException("In the wrong state for this action.");
        }
    }
    
    public void onPause(GameEngine engine) {
        
    }
}
