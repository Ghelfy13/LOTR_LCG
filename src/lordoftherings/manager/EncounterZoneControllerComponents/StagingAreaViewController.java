//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.ArrayList;
import lordoftherings.boardcomponents.StagingArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EnemyAreaView;
import lordoftherings.gui.EncounterZoneComponents.LocationAreaView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController.DISTANCE_FROM_FRAME;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class StagingAreaViewController {
    
    private StagingAreaView view;
    private BoardActiveState bas;
    private StagingArea stage;
    private EnemyAreaViewController enemyAreaVC;
    private LocationAreaViewController locationAreaVC;
    private ActiveLocationViewController activeLocationVC;
    private ArrayList<Enemy> myEnemies;
    public static final int AREA_X_VALUE = 225;
    
    public  StagingAreaViewController(BoardActiveState bas, StagingArea stage){
        this.bas = bas;
        this.stage = stage;
        this.enemyAreaVC = new EnemyAreaViewController(bas, stage.getEnemyArea());
        this.locationAreaVC = new LocationAreaViewController(stage.getLocationArea(), bas);
        this.activeLocationVC = new ActiveLocationViewController(bas, stage.getActiveLocationArea());
        this.myEnemies = new ArrayList<>(stage.getEnemyArea().getNumOfEnemies());
        
    }
    
    public StagingAreaView makeView(int x, int y){
        view = new StagingAreaView(x, y, bas.createMouseFollower());
        EnemyAreaView enemyView = enemyAreaVC.makeView(AREA_X_VALUE, DISTANCE_FROM_FRAME);
        view.add(enemyView);
        LocationAreaView locationView = locationAreaVC.makeView(
                AREA_X_VALUE + enemyAreaVC.getAreaLength(), DISTANCE_FROM_FRAME);
        view.add(locationView);
        ActiveLocationView activeLocationView = activeLocationVC.makeView(0, 0);
        view.add(activeLocationView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        enemyAreaVC.updateView(AREA_X_VALUE);
        locationAreaVC.updateView(AREA_X_VALUE + enemyAreaVC.getAreaLength());
        activeLocationVC.updateView();
    }
       
}
