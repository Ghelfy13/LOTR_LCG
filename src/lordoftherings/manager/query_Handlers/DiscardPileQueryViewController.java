//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.query_components.DiscardPileQueryPlayerZoneView;
import lordoftherings.gui.query_components.DiscardPileQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.BoardControllerComponents.BoardViewController;
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
        view = new DiscardPileQueryView();
        view.add(dPileQAS.getFocusableText());
        view.addMouseMotionListener(dPileQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(1995, 0, description);
        view.add(messageView);
        DiscardPileQueryPlayerZoneView playerZoneView = playerZoneVC.makeView(BoardViewController.DISTANCE_FROM_FRAME, 
                ActiveLocationView.CARD_COUNTER_HEIGHT + BoardViewController.
                DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE);
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
