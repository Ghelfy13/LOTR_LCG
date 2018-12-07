//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.ActiveLocationArea;
import lordoftherings.boardcomponents.StagingArea;
import lordoftherings.boardcomponents.Location;
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
    public static final int X_POSITION = 8;
    public static final int Y_POSITION = 3;
    private GameConfiguration config;
    
    public ActiveLocationViewController(BoardActiveState bas, ActiveLocationArea locationArea, GameConfiguration config){
        this.bas = bas;
        this.activeZone= locationArea;
        this.currentLocation = locationArea.getActiveLocation();
        if(currentLocation != null){
           this.locationVC = new LocationViewController(currentLocation, bas, config); 
        }
        this.config = config;
        
    }
    
    public ActiveLocationView makeView(int x, int y){
        view = new ActiveLocationView(x, y, config);
        if(locationVC != null){
            locationView = locationVC.makeView(X_POSITION, Y_POSITION);
            view.add(locationView);
        }
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        if(currentLocation != activeZone.getActiveLocation()){
            if(activeZone.getActiveLocation() != null){
                currentLocation = activeZone.getActiveLocation();
                locationVC = new LocationViewController(currentLocation, bas, config);
                locationView = locationVC.makeView(X_POSITION, Y_POSITION);
                view.add(locationView);
            }else{
                view.removeAll();
            }
            
        }else if(currentLocation == activeZone.getActiveLocation() && currentLocation != null){
            locationVC.updateView(X_POSITION, Y_POSITION);
        }
        view.revalidate();
        view.repaint();
    }
        
    
    
    public LocationView getView(){//Can return null;
        return locationView;
    }
}
