//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.ArrayList;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Location;
import lordoftherings.gui.EncounterZoneComponents.LocationCardView;
import lordoftherings.gui.EncounterZoneComponents.LocationTokenView;
import lordoftherings.gui.EncounterZoneComponents.LocationView;
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
    private LocationTokenViewController tokenVC;
    private Location location;
    private BoardActiveState bas;
    private LocationCardView cardView;
    private LocationTokenView tokenView;
    
    public LocationViewController(Location location, BoardActiveState bas){
        this.location = location;
        this.bas = bas;
        cardVC = new LocationCardViewController(location.getCard(), bas);
        tokenVC = new LocationTokenViewController();
    }
    
    public LocationView makeView(int x, int y){
        view = new LocationView(x, y);
        cardView = cardVC.makeView(0,0);
        cardView.addMouseListener(new ActionableMouseListener(bas, this));
        view.add(cardView);
        tokenView = tokenVC.makeView(0, 250);
        view.add(tokenView);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(int x, int y){
        view.setLocation(x, y);
        cardVC.updateView();
        tokenVC.updateView(location.getNumOfTokens());
        view.revalidate();
        view.repaint();
    }
    
    public LocationView getView(){
        return view;
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
    
}
