//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.LocationArea;
import lordoftherings.boardcomponents.Location;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.LocationAreaView;
import lordoftherings.gui.EncounterZoneComponents.LocationView;
import static lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController.DISTANCE_FROM_FRAME;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class LocationAreaViewController{
    private LocationArea area;
    private LocationAreaView view;
    private BoardActiveState bas;
    private HashMap<Location, LocationViewController> controllerMap;
    public static final int AREA_X_VALUE = 225;
    public static final int AREA_SPACING = 160;
    private GameConfiguration config;
    
    public LocationAreaViewController(LocationArea area, 
            BoardActiveState bas, GameConfiguration config){
        this.area = area;
        this.bas = bas;
        this.controllerMap = new HashMap<>();
        this.config = config;
    }
    
    public LocationAreaView makeView(int x, int y){
        view = new LocationAreaView(x, y, area.getSizeOfList(), 
                bas.createMouseFollower(), config);
        for(int i = 0; i < area.getSizeOfList(); ++i){
            Location current = area.getLocationAt(i);
            LocationViewController locationVC = new LocationViewController(
                    area.getLocationAt(i), bas, config);
            controllerMap.put(current, locationVC);
            LocationView locationV = locationVC.makeView(
                    i*AREA_X_VALUE, 0);
            view.add(locationV);
        }
        view.setVisible(true);
        return view;
    }
    
    public void updateView(int x){
        view.setBounds(config.scale(x), config.scale(DISTANCE_FROM_FRAME), 
                config.scale(area.getSizeOfList()*AREA_SPACING),
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
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
                LocationViewController controller = new LocationViewController(
                        current, bas, config);
                controllerMap.put(current, controller);
                LocationView locationView = controller.makeView(
                        i*AREA_SPACING, 0);
                view.add(locationView);
            }
            else{
                LocationViewController controller = controllerMap.get(current);
                controller.updateView(i*AREA_SPACING, 0);
            }
        }
        view.revalidate();
        view.repaint();
    }
    
}
