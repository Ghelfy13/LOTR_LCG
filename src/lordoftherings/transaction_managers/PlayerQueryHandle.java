//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.PlayerZone;

/**
 *
 * @author Amanda
 */
public class PlayerQueryHandle extends QueryHandle{
    
    public PlayerQueryHandle(PlayerQueryRequirements requirements,
            ResultHandler<ArrayList<PlayerZone>> resultHandler, 
            CancelHandler cancelHandler){
        super(requirements, resultHandler, cancelHandler);
    }
    
}
