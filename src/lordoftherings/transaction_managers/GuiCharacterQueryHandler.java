//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryHandler;

/**
 *
 * @author Amanda
 */
public class GuiCharacterQueryHandler implements CharacterQueryHandler {
    
    GameManagerViewController gameMVC;
    
    public GuiCharacterQueryHandler(GameManagerViewController gameMVC){
        this.gameMVC = gameMVC;
    }

    @Override
    public void handleQuery(CharacterQueryHandle handle, String descriptionOfQuest) {
        gameMVC.setGlassPaneToVisible();
        gameMVC.setUpCharacterQuery(descriptionOfQuest, handle);
        gameMVC.updateView();
    }
    
}
