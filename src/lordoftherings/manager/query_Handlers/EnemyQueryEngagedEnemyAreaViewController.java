//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.query_components.EnemyQueryEnemyView;
import lordoftherings.gui.query_components.EnemyQueryEngagedEnemyAreaView;
import lordoftherings.manager.PlayerZoneControllerCompoents.AllyZoneViewController;
import lordoftherings.transaction_managers.EnemyQueryHandle;


/**
 *
 * @author Amanda
 */
public class EnemyQueryEngagedEnemyAreaViewController{
    private EnemyQueryViewController queryVC;
    private EngagedEnemyArea enemyArea;
    private EnemyQueryActiveState enemyQAS;
    private EnemyQueryEngagedEnemyAreaView view;
    private EnemyQueryHandle handle;
    private HashMap<Enemy, EnemyQueryEnemyViewController> controllerMap;
    private EnemyQueryEnemyViewController enemyVC;
    
    public EnemyQueryEngagedEnemyAreaViewController(EnemyQueryViewController queryVC,
            EngagedEnemyArea enemyArea, EnemyQueryActiveState enemyQAS){
        this.enemyArea = enemyArea;
        this.queryVC = queryVC;
        this.enemyQAS = enemyQAS;
        this.handle = (EnemyQueryHandle) queryVC.getHandle();
        this.controllerMap = new HashMap<>();
    }
    
    public EnemyQueryEngagedEnemyAreaView makeView(int x, int y){
        view = new EnemyQueryEngagedEnemyAreaView(x, y, enemyArea.getListOfEnemies().size());
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
            if(enemyArea.findEnemyIndex(entry.getKey()) == -1){
                deadEnemies.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        
        for(Enemy deadEnemy: deadEnemies){
            controllerMap.remove(deadEnemy);
        }
        
        for(int i = 0; i < enemyArea.getSize(); ++i){
            Enemy current = enemyArea.getListOfEnemies().get(i);
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
