//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.NAME_X;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.NAME_Y;
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
    private GameConfiguration config;
    
     public QueryPlayerZoneViewController(PlayerQueryViewController playerQVC, 
            PlayerZone playerZone, PlayerQueryActiveState playerQAS, GameConfiguration config){
        this.queryVC = playerQVC;
        this.zone = playerZone;
        this.playerQAS = playerQAS;
        this.nameVC = new QueryPlayerNameViewController(playerZone.getPlayerName(), 
                playerQAS, playerZone, config);
        this.handle = (PlayerQueryHandle) playerQVC.getHandle();
        this.config = config;
    }
    
    public QueryPlayerZoneView makeView(int x, int y){
        zoneView = new QueryPlayerZoneView(x, y, config);
        zoneView.add(playerQAS.getFocusableText());
        zoneView.addMouseMotionListener(playerQAS.createMouseFollower());
        QueryPlayerNameView nameView = nameVC.makeView(NAME_X, NAME_Y);
        zoneView.add(nameView);
        zoneView.setVisible(true);
        return zoneView;
    }
    
    public void updateView(){
        nameVC.updateView();
    }
}
