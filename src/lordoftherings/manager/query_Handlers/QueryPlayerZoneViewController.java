//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.Y_HAND_VALUE;

/**
 *
 * @author Amanda
 */
public class QueryPlayerZoneViewController {
    private PlayerZone zone;
    private PlayerQueryActiveState playerQAS;
    private QueryPlayerNameViewController nameVC;
    
    public QueryPlayerZoneViewController(PlayerZone zone, 
            PlayerQueryActiveState playerQAS){
        this.zone = zone;
        this.playerQAS = playerQAS;
        this.nameVC = new QueryPlayerNameViewController(zone.getPlayerName(), 
                playerQAS, zone.getOwner());
    }
    
    public QueryPlayerZoneView makeView(int x, int y){
        QueryPlayerZoneView view = new QueryPlayerZoneView(x, y);
        view.add(playerQAS.getFocusableText());
        view.addMouseMotionListener(playerQAS.createMouseFollower());
        QueryPlayerNameView nameView = nameVC.makeView(60, Y_HAND_VALUE - 100);
        view.add(nameView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        nameVC.updateView();
    }
}
