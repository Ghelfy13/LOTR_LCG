//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.boardcomponents.EnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.EnemyAreaView;
import lordoftherings.gui.EncounterZoneComponents.EnemyView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class EnemyAreaViewController {
    private EnemyAreaView view;
    private EnemyArea area;
    private HashMap<Enemy, EnemyViewController> controllerMap;
    private BoardActiveState bas;
    public final static int Y_COORDINATE = 0;
    public final static int ALLY_WIDTH = 255;
    
    
    public EnemyAreaViewController(BoardActiveState bas, EnemyArea area){
        this.bas = bas;
        this.area = area;
        this.controllerMap = new HashMap<>();
    }
    
    public EnemyAreaView makeView(int x, int y){
        view = new EnemyAreaView(x, y, area.getNumOfEnemies(), bas.createMouseFollower());
        for(int i = 0; i < area.getNumOfEnemies(); ++i){
            Enemy currentEnemy = area.getListOfEnemies().get(i);
            EnemyViewController currentController = new EnemyViewController(bas,currentEnemy);
            controllerMap.put(currentEnemy, currentController);
            EnemyView newView = currentController.makeView(i*ALLY_WIDTH, Y_COORDINATE);
            view.add(newView);
        }
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        HashSet<Enemy> cardsToRemove = new HashSet<>();
        for(Map.Entry<Enemy, EnemyViewController> entry: controllerMap.entrySet()){
            if(!area.findCard(entry.getKey())){
                cardsToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        for(Enemy enemy: cardsToRemove){
            controllerMap.remove(enemy);
        }
        int len = area.getNumOfEnemies();
        for(int i = 0; i < len; ++i){
            Enemy enemy = area.getEnemyAt(i);
            if(!controllerMap.containsKey(enemy)){
                EnemyViewController controller = new EnemyViewController(bas, enemy);
                EnemyView eView = controller.makeView(i*255, Y_COORDINATE);
                view.add(eView);
                controllerMap.put(enemy, controller);
            }
            else{
                EnemyViewController cardController = controllerMap.get(enemy);
                cardController.updateView(i*255, Y_COORDINATE);
            }
        }
        view.revalidate();
        view.repaint();
    }
}
