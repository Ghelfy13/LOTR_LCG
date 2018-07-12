//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public interface PlayerQueryHandler {
    
    void handleQuery(PlayerQueryHandle handle, String descriptionOfAction);
}
