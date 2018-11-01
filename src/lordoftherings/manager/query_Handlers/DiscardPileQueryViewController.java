//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.manager.actionComponents.GlobalViewController;
import lordoftherings.transaction_managers.DiscardPileQueryHandle;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryViewController extends QueryViewController<DiscardPile>
    implements CancellableQueryViewController, GlobalViewController{
    
    private DiscardPileQueryView view;
    private DiscardPileQueryActiveState dPileQAS;
    private DiscardPileQueryPlayerZoneViewController playerZoneVC;

    public DiscardPileQueryViewController(GameManagerViewController gameMVC, DiscardPileQueryHandle handle) {
        super(gameMVC, handle);
    }

    @Override
    public QueryView makeView(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QueryView getView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getMousePosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
