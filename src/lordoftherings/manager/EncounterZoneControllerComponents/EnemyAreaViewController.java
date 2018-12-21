//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.EnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EnemyAreaView;
import lordoftherings.gui.EncounterZoneComponents.EnemyView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController.DISTANCE_FROM_FRAME;
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
    public static final int SPACING_X_VALUE = 160;
    private int enemyLen;
    private GameConfiguration config;
    
    public EnemyAreaViewController(BoardActiveState bas, EnemyArea area, GameConfiguration config){
        this.bas = bas;
        this.area = area;
        this.controllerMap = new HashMap<>();
        enemyLen = area.getNumOfEnemies()*SPACING_X_VALUE;
        this.config = config;
    }
    
    public EnemyAreaView makeView(int x, int y){
        view = new EnemyAreaView(x, y, area.getNumOfEnemies(), bas.createMouseFollower(), config);
        for(int i = 0; i < area.getNumOfEnemies(); ++i){
            Enemy currentEnemy = area.getListOfEnemies().get(i);
            EnemyViewController currentController = new EnemyViewController(bas, currentEnemy, config);
            controllerMap.put(currentEnemy, currentController);
            EnemyView newView = currentController.makeView(
                    i*SPACING_X_VALUE, Y_COORDINATE);
            view.add(newView);
        }
        view.setVisible(true);
        return view;
    }
    
    public int getAreaLength(){
        return enemyLen;
    }
    
    public void updateView(int x){
        view.setBounds(config.scale(x), config.scale(DISTANCE_FROM_FRAME), config.scale(ActiveLocationView.PARENT_WIDTH*area.getNumOfEnemies()), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
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
                EnemyViewController controller = new EnemyViewController(bas, enemy, config);
                EnemyView eView = controller.makeView(
                        i*SPACING_X_VALUE, Y_COORDINATE);
                view.add(eView);
                controllerMap.put(enemy, controller);
            }
            else{
                EnemyViewController cardController = controllerMap.get(enemy);
                cardController.updateView(i*SPACING_X_VALUE,Y_COORDINATE);
            }
        }
        enemyLen = area.getNumOfEnemies()*SPACING_X_VALUE;
        view.revalidate();
        view.repaint();
    }
}
