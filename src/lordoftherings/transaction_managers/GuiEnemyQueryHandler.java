//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;

/**
 *
 * @author Amanda
 */
public class GuiEnemyQueryHandler implements EnemyQueryHandler{

    GameManagerViewController gameMVC;
    
    public GuiEnemyQueryHandler(GameManagerViewController gameMVC){
        this.gameMVC = gameMVC;
    }

    @Override
    public void handleQuery(EnemyQueryHandle handle, String descriptionOfQuest) {
        gameMVC.setGlassPaneToVisible();
        gameMVC.setUpEnemyQuery(handle ,descriptionOfQuest);
        gameMVC.updateView();
    }
    
}
