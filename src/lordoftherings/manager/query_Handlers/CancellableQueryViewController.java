//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.transaction_managers.CancelHandler;

/**
 *
 * @author Amanda
 */
public interface CancellableQueryViewController {

    CancelHandler getCancelHandler();

    void deactivate();
    
}
