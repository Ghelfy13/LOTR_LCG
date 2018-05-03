//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.characters.Location;

/**
 *
 * @author Amanda
 */
public class ActiveLocationArea {
    private Location activeLocation;
    
    public ActiveLocationArea(){
        activeLocation = null;
    }
    
    public void setActiveLocation(Location newLocation){
        activeLocation = newLocation;
    }
    
    public Location getActiveLocation(){//can return null;
        return activeLocation;
    }
    
    public void unsetActiveLocation(){
        activeLocation = null;
    }
}
