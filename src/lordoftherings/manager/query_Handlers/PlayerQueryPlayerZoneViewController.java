//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class PlayerQueryPlayerZoneViewController {
    private QueryPlayerZoneView zoneView;
    private PlayerZone playerZone;
    private PlayerQueryActiveState playerQAS;
    private QueryPlayerNameViewController nameVC;
    private PlayerQueryViewController queryVC;
    private PlayerQueryHandle handle;
    
    public PlayerQueryPlayerZoneViewController(PlayerQueryViewController playerQVC, 
            PlayerZone playerZone, PlayerQueryActiveState playerQAS){
        this.queryVC = playerQVC;
        this.playerZone = playerZone;
        this.playerQAS = playerQAS;
        this.nameVC = new QueryPlayerNameViewController(playerZone.getPlayerName(), 
                playerQAS, playerZone.getOwner());
        this.handle = (PlayerQueryHandle) playerQVC.getHandle();
    }
}
