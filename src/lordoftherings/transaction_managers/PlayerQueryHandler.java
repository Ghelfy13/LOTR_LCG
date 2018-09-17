//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;


/**
 *
 * @author Amanda
 */
public interface PlayerQueryHandler {
    
    void handleQuery(PlayerQueryHandle handle, String descriptionOfAction);
}
