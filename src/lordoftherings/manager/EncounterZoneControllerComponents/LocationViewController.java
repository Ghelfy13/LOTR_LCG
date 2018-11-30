//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.ArrayList;
import javax.swing.JComponent;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.Location;
import lordoftherings.gui.EncounterZoneComponents.LocationCardView;
import lordoftherings.gui.EncounterZoneComponents.TokenView;
import lordoftherings.gui.EncounterZoneComponents.LocationView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.Actionable;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class LocationViewController implements Actionable{
    private LocationView view;
    private LocationCardViewController cardVC;
    private TokenViewController tokenVC;
    private Location location;
    private BoardActiveState bas;
    private LocationCardView cardView;
    private TokenView tokenView;
    public static final int ACTIONS_Y_COORDINATE = 180;
    public static final int TOKEN_Y_VALUE = 200;
    
    public LocationViewController(Location location, BoardActiveState bas){
        this.location = location;
        this.bas = bas;
        cardVC = new LocationCardViewController(location.getCard(), bas);
        tokenVC = new TokenViewController();
    }
    
    public LocationView makeView(int x, int y){
        view = new LocationView(x, y);
        cardView = cardVC.makeView(0,0);
        cardView.addMouseListener(new ActionableMouseListener(bas, this));
        view.add(cardView);
        tokenView = tokenVC.makeView(0, TOKEN_Y_VALUE);
        view.add(tokenView);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(int x, int y){
        view.setLocation(scale(x), scale(y));
        cardVC.updateView();
        tokenVC.updateView(location.getNumOfTokens());
        view.revalidate();
        view.repaint();
    }
    
        
    @Override
    public void onSetActionable() {
        cardView.setBorder(BoardActiveState.ACTIVE_BORDER);
    }

    @Override
    public void onUnsetActionable() {
        cardView.setBorder(BoardActiveState.INACTIVE_BORDER);
    }

    @Override
    public void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState) {
        location.getCard().getActions(listOfActions, boardState, askingID);
    }

    @Override
    public String getViewingText() {
        return location.getCard().getTitle();
    }

    @Override
    public JComponent getView(){
        return view;
    }

    

    @Override
    public int getActionsYCoordinate() {
        return ACTIONS_Y_COORDINATE;
    }
    
}
