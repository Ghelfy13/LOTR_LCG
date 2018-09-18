//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.gui.query_components.EnemyQueryEngagedEnemyAreaView;
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
    
    public EnemyQueryEngagedEnemyAreaViewController(EnemyQueryViewController queryVC,
            EngagedEnemyArea enemyArea, EnemyQueryActiveState enemyQAS){
        this.enemyArea = enemyArea;
        this.queryVC = queryVC;
        this.enemyQAS = enemyQAS;
        this.handle = (EnemyQueryHandle) queryVC.getHandle();
    }
    
    public EnemyQueryEngagedEnemyAreaView makeView(int x, int y){
        view = new EnemyQueryEngagedEnemyAreaView(x, y, enemyArea.getListOfEnemies().size());
        view.add(enemyQAS.getFocusableText());
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){}//TODO
}
