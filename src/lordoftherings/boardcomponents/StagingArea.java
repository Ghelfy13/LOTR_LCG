//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.LocationOnBoard;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;


/**
 *
 * @author Amanda
 */
public class StagingArea {
    private EnemyArea enemyZone;
    private LocationArea locationZone;
    private ActiveLocationArea activeLocationZone;
    
    public StagingArea(){
        this.enemyZone = new EnemyArea();
        this.locationZone = new LocationArea();
        this.activeLocationZone = new ActiveLocationArea();
    }
    
    public EnemyArea getEnemyArea(){
        return enemyZone;
    }
    
    public void addLocation(Location newLocation){
        locationZone.addLocation(newLocation);
    }
    
    public void addLocationToActiveLocation(Location newActiveLocation){
        activeLocationZone.setActiveLocation(newActiveLocation);
        
    }
    
    public void removeEnemyAt(int index){
        enemyZone.removeEnemyAt(index);
    }
    
    public void removeEnemy(Enemy wantedEnemy){
        enemyZone.removeEnemy(wantedEnemy);
    }
    
    public LocationArea getLocationArea(){
        return locationZone;
    }
    
    public ActiveLocationArea getActiveLocationArea(){
        return activeLocationZone;
    }
    
    public int getCurrentThreat(){
        int threat = 0;
        for( int i = 0; i < enemyZone.getNumOfEnemies(); ++i){
            threat += enemyZone.getEnemyAt(i).getThreat();
        }
        for(int i = 0; i < locationZone.getSizeOfList(); ++i){
            threat += locationZone.getLocationAt(i).getThreat();
        }
        return threat;
    }
    
    public Enemy getEnemyAt(int index){
        return enemyZone.getEnemyAt(index);
    }
    
    public Enemy getEnemyFromCard(EnemyCard card){
        int index = enemyZone.findEnemyByCard(card);
        if(index != -1){
            return enemyZone.getEnemyAt(index);
        }
        return null;
    }
}
