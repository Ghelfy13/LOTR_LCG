//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.transaction_managers.PlayerQueryHandler;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class GuiPlayerQueryHandler implements PlayerQueryHandler{
    
    private GameManagerViewController gameMVC;
    
    public GuiPlayerQueryHandler(GameManagerViewController gameMVC){
        this.gameMVC = gameMVC;
    }

    @Override
    public void handleQuery(PlayerQueryHandle handle, String descriptionOfAction) {
        gameMVC.setGlassPaneToVisible();
        gameMVC.setUpPlayerQuery(handle, descriptionOfAction);
        gameMVC.updateView();
    }
    
    
    
}
