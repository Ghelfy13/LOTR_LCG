//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.DiscardPile;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryHandle extends QueryHandle{
    
    public DiscardPileQueryHandle(DiscardPileQueryRequirements requirements, 
            ResultHandler<ArrayList<DiscardPile>> resultHandler, CancelHandler cancelHandler) {
        super(requirements, resultHandler, cancelHandler);
    }
    
}
