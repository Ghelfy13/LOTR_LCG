//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.boardcomponents.ActiveLocationArea;
import lordoftherings.boardcomponents.StagingArea;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class ActiveLocationViewController {
    private StagingArea area;
    private ActiveLocationView view;
    private ActiveLocationArea currentLocation;
    private BoardActiveState bas;
    
    
    public ActiveLocationViewController(BoardActiveState bas, ActiveLocationArea currentLocation){
        this.bas = bas;
        this.currentLocation = currentLocation;
    }
    
    public ActiveLocationView makeView(int x, int y){
        view = new ActiveLocationView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        //TODO: Add view of currentLocation to this view
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        //TODO
    }
}
