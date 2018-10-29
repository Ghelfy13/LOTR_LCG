//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

/**
 *
 * @author Amanda
 */
public interface DiscardPileQueryHandler {
    
    void handleQuery(DiscardPileQueryHandle handle, String descriptionOfAction);
}
