//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.boardcomponents.ActiveLocationArea;
import lordoftherings.boardcomponents.StagingArea;
import lordoftherings.characters.Location;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.LocationView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class ActiveLocationViewController {
    private StagingArea area;
    private ActiveLocationView view;
    private ActiveLocationArea activeZone;
    private BoardActiveState bas;
    private LocationViewController locationVC;
    private Location currentLocation;
    private LocationView locationView;
    public static final int X_POSITION = 7;
    
    public ActiveLocationViewController(BoardActiveState bas, ActiveLocationArea locationArea){
        this.bas = bas;
        this.activeZone= locationArea;
        this.currentLocation = locationArea.getActiveLocation();
        this.locationVC = new LocationViewController(currentLocation, bas);
    }
    
    public ActiveLocationView makeView(int x, int y){
        view = new ActiveLocationView(x, y);
        locationView = locationVC.makeView(X_POSITION, 0);
        view.add(locationView);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        if(activeZone.getActiveLocation() != null){
            if(currentLocation != activeZone.getActiveLocation()){
                view.remove(locationView);
                currentLocation = activeZone.getActiveLocation();
                locationVC = new LocationViewController(currentLocation, bas);
                locationView = locationVC.makeView(X_POSITION, 0);
                view.add(locationView);
            }else{
                locationVC.updateView();
            }
            view.revalidate();
            view.repaint();
        }
        
    }
    
    public LocationView getView(){//Can return null;
        return locationView;
    }
}
