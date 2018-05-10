//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import java.util.ArrayList;
import lordoftherings.gui.query_components.CharacterQueryMessageView;
import lordoftherings.gui.query_components.CharacterQueryView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.transaction_managers.CancelHandler;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.characters.GameCharacter;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.manager.BoardControllerComponents.BoardViewController;
import lordoftherings.manager.actionComponents.GlobalViewController;

/**
 *
 * @author Amanda
 */
public class CharacterQueryViewController implements CancellableQueryViewController, GlobalViewController{
    
    private CharacterQueryView view;
    private GameManagerViewController gameMVC;
    private CharacterQueryHandle handle;
    private CharacterQueryMessageViewController messageVC;
    private ArrayList<GameCharacter> resultList;
    private QueryPlayerZoneViewController playerZoneVC;
    private CharacterQueryActiveState charQAS;
    
    public CharacterQueryViewController(GameManagerViewController gameMVC, CharacterQueryHandle handle){
        this.messageVC = new CharacterQueryMessageViewController(this, handle);
        this.charQAS = new CharacterQueryActiveState(this);
        this.handle = handle;
        this.gameMVC = gameMVC;
        this.resultList = new ArrayList<>();
        this.playerZoneVC = new QueryPlayerZoneViewController(this, gameMVC.getBoard().getCurrentPlayerZone(), charQAS);
        
    }
    
    public CharacterQueryView makeView(String description){
        view = new CharacterQueryView();
        view.add(charQAS.getFocusableText());
        view.addMouseMotionListener(charQAS.createMouseFollower());
        CharacterQueryMessageView messageView = messageVC.makeView(1995, 0, description);
        view.add(messageView);
        QueryPlayerZoneView playerZoneView = playerZoneVC.makeView(
                BoardViewController.DISTANCE_FROM_FRAME, 
                ActiveLocationView.CARD_COUNTER_HEIGHT + BoardViewController.DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE);
        playerZoneView.setVisible(true);
        view.add(playerZoneView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        messageVC.updateView();
        playerZoneVC.updateView();
    }

    public CharacterQueryView getView() {
        return view;
    }
    
    public CharacterQueryHandle getHandle(){
        return handle;
    }
    
     @Override
    public CancelHandler getCancelHandler() {
        return handle.getCancelHandler();
    }

    @Override
    public void deactivate() {
        gameMVC.deactivateCharQueryVC();
    }

    public ArrayList<GameCharacter> getResult() {
        return resultList;
    }
    
    public boolean resultIsFull(){
        return handle.getMax() == resultList.size();
    }

    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }

    boolean resultContains(GameCharacter currentCharacter) {
        return resultList.contains(currentCharacter);
    }

    public void removeFromResult(GameCharacter currentCharacter) {
        resultList.remove(currentCharacter);
    }

    public void addToResult(GameCharacter currentCharacter) {
        resultList.add(currentCharacter);
    }
    
    public QueryPlayerZoneViewController getQueryPlayerZoneVC(){
        return playerZoneVC;
    }

    void updateParentView() {
        gameMVC.updateView();
    }
}
