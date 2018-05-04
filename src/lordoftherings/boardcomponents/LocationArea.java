//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.characters.Location;


/**
 *
 * @author Amanda
 */
public class LocationArea {
    private ArrayList<Location> listOfLocations;
    
    public LocationArea(){
        listOfLocations = new ArrayList<>();
    }
    
    public void addLocation(Location newLocation){
        listOfLocations.add(newLocation);
    }
    
    public void removeLocation(Location wantedLocation){
        listOfLocations.remove(wantedLocation);
    }
    
    public void removeLocationAt(int index){
        listOfLocations.remove(index);
    }
    
    public Location getLocationAt(int index){
        return listOfLocations.get(index);
    }
    
    public boolean findLocation(Location wanted){
        for(int i = 0; i < listOfLocations.size(); ++i){
            if(listOfLocations.get(i) == wanted){
                return true;
            }
        }
        return false;
    }
    
    public int getSizeOfList(){
        return listOfLocations.size();
    }
}
