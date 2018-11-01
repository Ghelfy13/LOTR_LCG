//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.DiscardPileQueryPileView;
import lordoftherings.gui.query_components.DiscardPileQueryPlayerZoneView;
import lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController;
import lordoftherings.transaction_managers.DiscardPileQueryHandle;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPlayerZoneViewController {
    private DiscardPileQueryPlayerZoneView zoneView;
    private DiscardPileQueryViewController dPileQVC;
    private DiscardPileQueryPileViewController dPileVC;
    private PlayerZone playerZone;
    private DiscardPileQueryActiveState dPileQAS;
    private DiscardPileQueryHandle handle;
    
    public DiscardPileQueryPlayerZoneViewController(DiscardPileQueryViewController queryController,
            PlayerZone zone, DiscardPileQueryActiveState dPileQAS){
        this.playerZone = zone;
        this.dPileQVC = queryController;
        this.handle = (DiscardPileQueryHandle) queryController.handle;
        this.dPileVC = new DiscardPileQueryPileViewController(dPileQAS, zone.getDPile());
    }
    
    public DiscardPileQueryPlayerZoneView makeView(int x, int y){
        zoneView = new DiscardPileQueryPlayerZoneView(x,y);
        zoneView.addMouseMotionListener(dPileQAS.createMouseFollower());
        DiscardPileQueryPileView pileView = dPileVC.makeView(0, 
                PlayerZoneViewController.Y_HAND_VALUE -10);
        zoneView.add(pileView);
        zoneView.setVisible(true);
        return zoneView;
    }
    
    public DiscardPileQueryHandle getHandle(){
        return handle;
    }
    
    public void updateView(){
        dPileVC.updateView();
    }
    
    
}
