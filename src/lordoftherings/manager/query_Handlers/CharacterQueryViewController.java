//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import java.util.ArrayList;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.gui.query_components.CharacterQueryView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.CancelHandler;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.characters.GameCharacter;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.BoardControllerComponents.BoardViewController;
import lordoftherings.manager.actionComponents.GlobalViewController;

/**
 *
 * @author Amanda
 */
public class CharacterQueryViewController extends QueryViewController<GameCharacter> implements CancellableQueryViewController, GlobalViewController{
    
    private CharacterQueryPlayerZoneViewController playerZoneVC;
    private CharacterQueryActiveState charQAS;
    private CharacterQueryView view;
    
    public CharacterQueryViewController(GameManagerViewController gameMVC, 
            CharacterQueryHandle handle){
        super(gameMVC, handle);
        this.charQAS = new CharacterQueryActiveState(this);
        this.playerZoneVC = new CharacterQueryPlayerZoneViewController(this, 
                gameMVC.getBoard().getCurrentPlayerZone(), charQAS);
        
    }
    
    @Override
    public QueryView makeView(String description){
        view = new CharacterQueryView();
        view.add(charQAS.getFocusableText());
        view.addMouseMotionListener(charQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(1995, 0, description);
        view.add(messageView);
        QueryPlayerZoneView playerZoneView = playerZoneVC.makeView(
                BoardViewController.DISTANCE_FROM_FRAME, 
                ActiveLocationView.CARD_COUNTER_HEIGHT + BoardViewController.
                        DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE);
        playerZoneView.setVisible(true);
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
