//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.boardcomponents.EnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.query_components.EnemyQueryEnemyAreaView;
import lordoftherings.gui.query_components.EnemyQueryEnemyView;
import lordoftherings.manager.PlayerZoneControllerCompoents.AllyZoneViewController;
import lordoftherings.transaction_managers.EnemyQueryHandle;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyAreaViewController {
    
    private EnemyQueryViewController queryVC;
    private EncounterZone encounterZone;
    private EnemyQueryActiveState enemyQAS;
    private EnemyQueryEnemyAreaView view;
    private EnemyQueryHandle handle;
    private HashMap<Enemy, EnemyQueryEnemyViewController> controllerMap;
    private EnemyArea enemyArea;
    private EnemyQueryEnemyViewController enemyVC;
    
    
    public EnemyQueryEnemyAreaViewController(EnemyQueryViewController queryVC,
            EncounterZone encounterZone, EnemyQueryActiveState enemyQAS){
        this.encounterZone = encounterZone;
        this.queryVC = queryVC;
        this.enemyQAS = enemyQAS;
        this.handle = (EnemyQueryHandle) queryVC.getHandle();
        controllerMap = new HashMap<>();
        this.enemyArea = encounterZone.getStagingArea().getEnemyArea();
        
    }
    
    public EnemyQueryEnemyAreaView makeView(int x, int y){
        view = new EnemyQueryEnemyAreaView(x, y, encounterZone.getStagingArea().
                getEnemyArea().getNumOfEnemies());
        view.add(enemyQAS.getFocusableText());
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        ArrayList<Enemy> listOfEnemies = enemyArea.getListOfEnemies();
        
        for(int i = 0; i < listOfEnemies.size(); ++i){
            Enemy current = listOfEnemies.get(i);
            if(handle.getMatcher().matches(current)){
                enemyVC = new EnemyQueryEnemyViewController(current, enemyQAS);
                controllerMap.put(current, enemyVC);
                EnemyQueryEnemyView enemyView = enemyVC.makeView(i*AllyZoneViewController.CARDS_AND_SPACE, 0);
                enemyView.setVisible(true);
                view.add(enemyView);
            }
        }
        view.setVisible(true);
        updateView();
        return view;
    }
    
    public void updateView(){
        HashSet<Enemy> deadEnemies = new HashSet<>();
        for(Map.Entry<Enemy, EnemyQueryEnemyViewController> entry: controllerMap.entrySet()){
            if(enemyArea.findEnemyByCard(entry.getKey().getCard()) == -1){
                deadEnemies.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        
        for(Enemy deadEnemy: deadEnemies){
            controllerMap.remove(deadEnemy);
        }
        
        for(int i = 0; i < enemyArea.getNumOfEnemies(); ++i){
            Enemy current = enemyArea.getEnemyAt(i);
            if(!controllerMap.containsKey(current)){
                enemyVC = new EnemyQueryEnemyViewController(current, enemyQAS);
                controllerMap.put(current, enemyVC);
                EnemyQueryEnemyView enemyView = enemyVC.makeView(i*AllyZoneViewController.CARDS_AND_SPACE, 0);
                enemyView.setVisible(true);
                view.add(enemyView);
            }
            else{
                controllerMap.get(current).updateView();
            }
        }
        view.revalidate();
        view.repaint();
    }
    
    public EnemyQueryHandle getHandle(){
        return handle;
    }
    
}
