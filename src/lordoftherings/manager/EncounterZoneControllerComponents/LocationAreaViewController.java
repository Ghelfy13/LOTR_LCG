//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.boardcomponents.LocationArea;
import lordoftherings.gui.EncounterZoneComponents.LocationAreaView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class LocationAreaViewController {
    private LocationArea area;
    private LocationAreaView view;
    private BoardActiveState bas;
    
    public LocationAreaViewController(LocationArea area, BoardActiveState bas){
        this.area = area;
        this.bas = bas;
    }
    
    public LocationAreaView makeView(int x, int y){
        view = new LocationAreaView(x, y, area.getSizeOfList(), bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        //TODO
    }
    
}
