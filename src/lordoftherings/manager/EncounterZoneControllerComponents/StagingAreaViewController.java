//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.ArrayList;
import lordoftherings.boardcomponents.StagingArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EnemyAreaView;
import lordoftherings.gui.EncounterZoneComponents.EnemyView;
import lordoftherings.gui.EncounterZoneComponents.LocationAreaView;
import lordoftherings.gui.EncounterZoneComponents.LocationView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaView;
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
        EnemyAreaView enemyView = enemyAreaVC.makeView(LocationView.LOCATION_WIDTH, 0);
        int enemyLen = enemyView.getLengthOfEnemyArea();
        view.add(enemyView);
        LocationAreaView locationView = locationAreaVC.makeView(LocationView.LOCATION_WIDTH + enemyLen, 0);
        view.add(locationView);
        ActiveLocationView activeLocationView = activeLocationVC.makeView(0, 0);
        view.add(activeLocationView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        enemyAreaVC.updateView(LocationView.LOCATION_WIDTH);
        locationAreaVC.updateView(LocationView.LOCATION_WIDTH + EnemyView.ENEMY_WIDTH*stage.getEnemyArea().getNumOfEnemies());
        activeLocationVC.updateView();
    }
       
}
