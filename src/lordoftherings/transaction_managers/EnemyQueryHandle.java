//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class EnemyQueryHandle extends QueryHandle{

    public EnemyQueryHandle(EnemyQueryRequirements requirements, 
            ResultHandler<ArrayList<Enemy>> resultHandler, CancelHandler cancelHandler) {
        super(requirements, resultHandler, cancelHandler);
    }
}
