//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.Y_HAND_VALUE;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class QueryPlayerZoneViewController {
    private QueryPlayerZoneView zoneView;
    private PlayerZone zone;
    private PlayerQueryActiveState playerQAS;
    private QueryPlayerNameViewController nameVC;
    private PlayerQueryViewController queryVC;
    private PlayerQueryHandle handle;
    
     public QueryPlayerZoneViewController(PlayerQueryViewController playerQVC, 
            PlayerZone playerZone, PlayerQueryActiveState playerQAS){
        this.queryVC = playerQVC;
        this.zone = playerZone;
        this.playerQAS = playerQAS;
        this.nameVC = new QueryPlayerNameViewController(playerZone.getPlayerName(), 
                playerQAS, playerZone);
        this.handle = (PlayerQueryHandle) playerQVC.getHandle();
    }
    
    public QueryPlayerZoneView makeView(int x, int y){
        zoneView = new QueryPlayerZoneView(x, y);
        zoneView.add(playerQAS.getFocusableText());
        zoneView.addMouseMotionListener(playerQAS.createMouseFollower());
        QueryPlayerNameView nameView = nameVC.makeView(60, Y_HAND_VALUE - 100);
        zoneView.add(nameView);
        zoneView.setVisible(true);
        return zoneView;
    }
    
    public void updateView(){
        nameVC.updateView();
    }
}
