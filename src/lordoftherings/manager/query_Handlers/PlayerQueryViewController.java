//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.PlayerQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.gui.query_components.QueryView;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_FROM_FRAME;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.PLAYERZONE_Y_COORDINATE;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import static lordoftherings.manager.query_Handlers.CharacterQueryViewController.MESSAGE_X;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class PlayerQueryViewController extends QueryViewController<PlayerZone>{
    
    private PlayerQueryView view;
    private PlayerQueryActiveState playerQAS;
    private QueryPlayerZoneViewController playerZoneQVC;
    private GameConfiguration config;
            
    public PlayerQueryViewController(GameManagerViewController gameMVC, 
            PlayerQueryHandle handle, GameConfiguration config){
        super(gameMVC, handle, config);
        this.playerQAS = new PlayerQueryActiveState(this);
        Board board = gameMVC.getBoard();
        playerZoneQVC = new QueryPlayerZoneViewController(this, board.getPlayerZoneAt(0),
                playerQAS, config);
        this.config = config;
    }

    @Override
    public QueryView makeView(String description) {
        view = new PlayerQueryView(config);
        view.add(playerQAS.getFocusableText());
        view.addMouseMotionListener(playerQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(MESSAGE_X, 0, description);
        QueryPlayerZoneView zoneView = playerZoneQVC.makeView(DISTANCE_FROM_FRAME, PLAYERZONE_Y_COORDINATE);
        view.add(messageView);
        view.add(zoneView);
        view.setVisible(true);
        return view;
    }

    @Override
    public void updateView() {
        messageVC.updateView();
        playerZoneQVC.updateView();
    }

    @Override
    public QueryView getView() {
        return view;
    }
    
     @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }
    
}
