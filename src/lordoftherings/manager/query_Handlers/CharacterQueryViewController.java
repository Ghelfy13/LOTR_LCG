//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.CharacterQueryView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.characters.GameCharacter;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.gui.query_components.QueryView;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_FROM_FRAME;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.PLAYERZONE_Y_COORDINATE;
import lordoftherings.manager.actionComponents.GlobalViewController;

/**
 *
 * @author Amanda
 */
public class CharacterQueryViewController extends QueryViewController<GameCharacter> 
    implements CancellableQueryViewController, GlobalViewController{
    
    private CharacterQueryPlayerZoneViewController playerZoneVC;
    private CharacterQueryActiveState charQAS;
    private CharacterQueryView view;
    public static final int MESSAGE_X = 1995;
    
    public CharacterQueryViewController(GameManagerViewController gameMVC, 
            CharacterQueryHandle handle, GameConfiguration config){
        super(gameMVC, handle, config);
        this.charQAS = new CharacterQueryActiveState(this);
        this.playerZoneVC = new CharacterQueryPlayerZoneViewController(this, 
                gameMVC.getBoard().getCurrentPlayerZone(), charQAS, config);
        
    }
    
    @Override
    public QueryView makeView(String description){
        view = new CharacterQueryView(config);
        view.add(charQAS.getFocusableText());
        view.addMouseMotionListener(charQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(MESSAGE_X, 0, description);
        view.add(messageView);
        QueryPlayerZoneView playerZoneView = playerZoneVC.makeView(
                DISTANCE_FROM_FRAME, PLAYERZONE_Y_COORDINATE);
        view.add(playerZoneView);
        view.setVisible(true);
        return view;
    }
    
    @Override
    public void updateView(){
        messageVC.updateView();
        playerZoneVC.updateView();
    }

    @Override
    public CharacterQueryView getView() {
        return view;
    }
    
    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }

    public CharacterQueryPlayerZoneViewController getQueryPlayerZoneVC(){
        return playerZoneVC;
    }
}
