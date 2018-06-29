//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public class PlayerZoneQueryHandle {
    private PlayerZoneQueryRequirements requirements;
    private ResultHandler<ArrayList<PlayerZone>> resultHandler;
    private CancelHandler cancelHandler;
    
    public PlayerZoneQueryHandle(PlayerZoneQueryRequirements requirements,
            ResultHandler<ArrayList<PlayerZone>> resultHandler, 
            CancelHandler cancelHandler){
        this.requirements = requirements;
        this.resultHandler = resultHandler;
        this.cancelHandler = cancelHandler;
    }
    
    public Matcher<PlayerZone> getMatcher(){
        return requirements.getMatcher();
    }
    
    public int getMin(){
        return requirements.getMin();
    }
    
    public int getMax(){
        return requirements.getMax();
    }
    
    public ResultHandler<ArrayList<PlayerZone>> getResultHandler(){
        return resultHandler;
    }
    
    public CancelHandler getCancelHandler(){
        return cancelHandler;
    }

    public PlayerZoneQueryRequirements getRequirements() {
        return requirements;
    }
}
