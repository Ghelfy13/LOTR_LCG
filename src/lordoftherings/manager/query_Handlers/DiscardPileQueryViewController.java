//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.gui.query_components.DiscardPileQueryPlayerZoneView;
import lordoftherings.gui.query_components.DiscardPileQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.QueryView;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_FROM_FRAME;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.PLAYERZONE_Y_COORDINATE;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.manager.actionComponents.GlobalViewController;
import static lordoftherings.manager.query_Handlers.CharacterQueryViewController.MESSAGE_X;
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

    public DiscardPileQueryViewController(GameManagerViewController gameMVC, 
            DiscardPileQueryHandle handle, GameConfiguration config) {
        super(gameMVC, handle, config);
    }

    @Override
    public QueryView makeView(String description) {
        view = new DiscardPileQueryView(config);
        view.add(dPileQAS.getFocusableText());
        view.addMouseMotionListener(dPileQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(MESSAGE_X, 0, description);
        view.add(messageView);
        DiscardPileQueryPlayerZoneView playerZoneView = 
                playerZoneVC.makeView(DISTANCE_FROM_FRAME, PLAYERZONE_Y_COORDINATE);
        view.add(playerZoneView);
        view.setVisible(true);
        return view;
    }

    @Override
    public void updateView() {
        playerZoneVC.updateView();
        
    }

    @Override
    public QueryView getView() {
        return view;
    }

    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }
    
    public DiscardPileQueryPlayerZoneViewController getDPileQueryPlayerZoneVC(){
        return playerZoneVC;
    }

}
