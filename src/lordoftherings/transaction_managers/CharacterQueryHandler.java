//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

/**
 *
 * @author Amanda
 */
public interface CharacterQueryHandler {
    
    void handleQuery(CharacterQueryHandle handle, String descriptionOfQuest);
}
