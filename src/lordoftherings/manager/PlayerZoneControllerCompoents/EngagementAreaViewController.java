//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.EnemyView;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.EncounterZoneControllerComponents.EnemyViewController;

/**
 *
 * @author Amanda
 */
public class EngagementAreaViewController {
    
    private BoardActiveState bas;
    private EngagedEnemyArea area;
    private EngagementAreaView view;
    private GameConfiguration config;
    private HashMap<Enemy, EnemyViewController> controllerMap;
    public static Border ATTACKING_BORDER = BorderFactory.
            createMatteBorder(5, 5, 5, 5, Color.RED);
    public static Border DEFENDING_BORDER = BorderFactory.
            createMatteBorder(5, 5, 5, 5, Color.BLUE);
    public static CompoundBorder ATTACKING_ACTIVE_BORDER = 
            new CompoundBorder(BoardActiveState.ACTIVE_BORDER, ATTACKING_BORDER);
    public static CompoundBorder DEFENDING_ACTIVE_BORDER = 
            new CompoundBorder(BoardActiveState.ACTIVE_BORDER, DEFENDING_BORDER);
    
    
    public EngagementAreaViewController(BoardActiveState bas, 
            EngagedEnemyArea zone, GameConfiguration config){
        this.bas = bas;
        this.area = zone;
        this.controllerMap = new HashMap<>();
        this.config = config;
    }
    
    public EngagementAreaView makeView(int x, int y){
        view = new EngagementAreaView(x, y, area.getSize(), config);
        view.addMouseMotionListener(bas.createMouseFollower());
        for(int i = 0; i < area.getSize(); ++i){
            Enemy currentEnemy = area.peek(i);
            EnemyViewController controller = new EnemyViewController(bas, currentEnemy, config);
            controllerMap.put(currentEnemy, controller);
            EnemyView newView = controller.makeView(
                    i*AllyZoneViewController.CARDS_AND_SPACE, 0);
            view.add(newView);
        }
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        HashSet<Enemy> cardsToRemove = new HashSet<>();
        for(Map.Entry<Enemy, EnemyViewController> entry: controllerMap.entrySet()){
            if(!area.isInEngagementArea(entry.getKey())){
                cardsToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        for(Enemy enemy: cardsToRemove){
            controllerMap.remove(enemy);
        }
        int len = area.getSize();
        for(int i = 0; i < len; ++i){
            Enemy currentEnemy = area.peek(i);
            if(!controllerMap.containsKey(currentEnemy)){
                EnemyViewController eController = new EnemyViewController(bas, currentEnemy, config);
                controllerMap.put(currentEnemy, eController);
                EnemyView eView = eController.makeView(
                        i*AllyZoneViewController.CARDS_AND_SPACE, 0);
                view.add(eView);
                eController.updateView(i*AllyZoneViewController.CARDS_AND_SPACE, 0);
            }else{
                EnemyViewController enemyVC = controllerMap.get(currentEnemy);
                enemyVC.updateView(i*AllyZoneViewController.CARDS_AND_SPACE, 0);
            }
        }
        
        view.revalidate();
        view.repaint();
    }
}
