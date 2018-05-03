//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class PhaseState {
    private GamePhase phase;
    //TODO: FIX THIS
    
    public PhaseState(){
        phase = GamePhase.RESOURCE;
    }
    
    public void advancePhase(Board boardState){
    }
    
    public String getPhase(){
        return phase.toString();
    }
    
}
