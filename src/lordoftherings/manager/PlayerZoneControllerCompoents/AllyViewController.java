//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.manager.actionComponents.Actionable;
import java.util.ArrayList;
import javax.swing.JComponent;
import lordoftherings.GameConfiguration;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Ally;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.AllyDamageView;
import lordoftherings.gui.PlayerZoneComponents.AllyView;
import lordoftherings.manager.EncounterZoneControllerComponents.LocationViewController;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class AllyViewController implements Actionable {
    
    private AllyCardViewController allyCardVC;
    private Ally wantedAlly;
    private AllyZoneViewController allyZoneVC;
    private AllyView view;
    private AllyDamageView damageView;
    private AllyCardView cardView;
    private BoardActiveState bas;
    private GameConfiguration config;
    public static final int ALLY_ACTIONS_Y_COORDINATE = 165;
    
    
    public AllyViewController(Ally passedInAlly, AllyZoneViewController allyZoneVC, 
            BoardActiveState bas, GameConfiguration config){
        this.wantedAlly = passedInAlly;
        this.view = null;
        this.damageView = null;
        this.allyZoneVC = allyZoneVC;
        this.cardView = null;
        this.bas = bas;
        this.config = config;
    }
    
    public AllyView makeView(int x, int y){
        view = new AllyView(x, y, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        allyCardVC = new AllyCardViewController(wantedAlly, this, bas, config);
        cardView = allyCardVC.makeView(0,0);
        cardView.addMouseListener(new ActionableMouseListener(bas, this));
        view.add(cardView);
        cardView.setVisible(true);
        damageView = new AllyDamageView(0, HeroViewController.POOL_X, 0, config);
        view.add(damageView);
        damageView.setVisible(true);
        view.setVisible(true);
        return view;
    }
     
    public void updateView(){
        allyCardVC.updateView(0, 0, wantedAlly.isExhausted(), wantedAlly.isCommitted());
        damageView.setText("Damage: " + wantedAlly.getDamage());
        view.setVisible(true);
        view.revalidate();
        view.repaint();
    }
    
    @Override
    public String getViewingText() {
        return wantedAlly.getCard().getTitle();
    }

   @Override
    public void onSetActionable() {
        if(wantedAlly.isCommitted()){
            cardView.setBorder(CharacterAreaViewController.COMMIT_ACTIVE_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.ACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void onUnsetActionable() {
        if(wantedAlly.isCommitted()){
            cardView.setBorder(CharacterAreaViewController.COMMIT_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState) {
        wantedAlly.getCard().getActions(listOfActions, boardState, askingID);
    }

    @Override
    public JComponent getView() {
        return view;
    }

    @Override
    public int getActionsYCoordinate() {
        if(wantedAlly.getCard().getLocation() == LocationOnBoard.HAND){
            return ALLY_ACTIONS_Y_COORDINATE;
        }
        return LocationViewController.ACTIONS_Y_COORDINATE;
    }

    
}
