//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.PlayerQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class PlayerQueryViewController extends QueryViewController<PlayerZone>{
    
    private PlayerQueryView view;
    private PlayerZone playerZone;
    private PlayerQueryActiveState playerQAS;
    private QueryPlayerNameViewController nameVC;
            
    public PlayerQueryViewController(GameManagerViewController gameMVC, 
            PlayerQueryHandle handle, PlayerZone zone){
        super(gameMVC, handle);
        this.playerZone = zone;
        this.playerQAS = new PlayerQueryActiveState(this);
        this.nameVC = new QueryPlayerNameViewController(zone.getPlayerName(),
                playerQAS,zone.getOwner());
    }

    @Override
    public QueryView makeView(String description) {
        view = new PlayerQueryView();
        view.add(playerQAS.getFocusableText());
        view.addMouseMotionListener(playerQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(1995, 0, description);
        view.add(messageView);
        QueryPlayerNameView nameView = nameVC.makeView(180, 1900);//TODO: need to fix
        view.add(nameView);
        view.setVisible(true);
        return view;
    }

    @Override
    public void updateView() {
        messageVC.updateView();
        nameVC.updateView();
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
