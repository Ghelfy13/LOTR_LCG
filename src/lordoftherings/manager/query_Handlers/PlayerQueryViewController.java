//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.query_components.PlayerQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.gui.query_components.QueryView;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_FROM_FRAME;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class PlayerQueryViewController extends QueryViewController<PlayerZone>{
    
    private PlayerQueryView view;
    private PlayerQueryActiveState playerQAS;
    private QueryPlayerZoneViewController playerZoneQVC;
            
    public PlayerQueryViewController(GameManagerViewController gameMVC, 
            PlayerQueryHandle handle){
        super(gameMVC, handle);
        this.playerQAS = new PlayerQueryActiveState(this);
        Board board = gameMVC.getBoard();
        playerZoneQVC = new QueryPlayerZoneViewController(board.getPlayerZoneAt(0),
                playerQAS);
    }

    @Override
    public QueryView makeView(String description) {
        view = new PlayerQueryView();
        view.add(playerQAS.getFocusableText());
        view.addMouseMotionListener(playerQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(1995, 0, description);
        QueryPlayerZoneView zoneView = playerZoneQVC.makeView(DISTANCE_FROM_FRAME,
                ActiveLocationView.CARD_COUNTER_HEIGHT + 
                        DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE);
        
        view.add(messageView);
        view.setVisible(true);
        return view;
    }

    @Override
    public void updateView() {
        messageVC.updateView();
        //TODO: UPDATE VIEW ON PLAYERZONES INDIVIDUALLY
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
