//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.boardcomponents.LocationArea;
import lordoftherings.characters.Location;
import lordoftherings.gui.EncounterZoneComponents.LocationAreaView;
import lordoftherings.gui.EncounterZoneComponents.LocationView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class LocationAreaViewController {
    private LocationArea area;
    private LocationAreaView view;
    private BoardActiveState bas;
    private HashMap<Location, LocationViewController> controllerMap;
    public static final int LOCATION_WIDTH = 200;
    public static final int LOCATION_HEIGHT = 275;
    
    public LocationAreaViewController(LocationArea area, BoardActiveState bas){
        this.area = area;
        this.bas = bas;
        this.controllerMap = new HashMap<>();
    }
    
    public LocationAreaView makeView(int x, int y){
        view = new LocationAreaView(x, y, area.getSizeOfList(), bas.createMouseFollower());
        for(int i = 0; i < area.getSizeOfList(); ++i){
            Location current = area.getLocationAt(i);
            LocationViewController locationVC = new LocationViewController(area.getLocationAt(i), bas);
            controllerMap.put(current, locationVC);
            LocationView locationV = locationVC.makeView(i*LOCATION_WIDTH, 0);
            view.add(locationV);
        }
        view.setVisible(true);
        return view;
    }
    
    public void updateView(int x){
        view.setBounds(x, 0, area.getSizeOfList()*LOCATION_WIDTH, LOCATION_HEIGHT);
        HashSet<Location> locationsToRemove = new HashSet<>();
        for(Map.Entry<Location, LocationViewController> entry: controllerMap.entrySet()){
            if(!area.findLocation(entry.getKey())){
                locationsToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        for(Location location: locationsToRemove){
            controllerMap.remove(location);
        }
        int len = area.getSizeOfList();
        for( int i = 0; i < len; ++i){
            Location current = area.getLocationAt(i);
            if(!controllerMap.containsKey(current)){
                LocationViewController controller = new LocationViewController(current, bas);
                controllerMap.put(current, controller);
                LocationView locationView = controller.makeView(i*LOCATION_WIDTH, 0);
                view.add(locationView);
            }
            else{
                LocationViewController controller = controllerMap.get(current);
                controller.updateView(i*LOCATION_WIDTH, 0);
            }
        }
        view.revalidate();
        view.repaint();
    }
    
}
