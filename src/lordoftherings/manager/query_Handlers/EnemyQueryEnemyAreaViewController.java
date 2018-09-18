//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.boardcomponents.EnemyArea;
import lordoftherings.gui.query_components.EnemyQueryEnemyAreaView;
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
    
    public EnemyQueryEnemyAreaViewController(EnemyQueryViewController queryVC,
            EncounterZone encounterZone, EnemyQueryActiveState enemyQAS){
        this.encounterZone = encounterZone;
        this.queryVC = queryVC;
        this.enemyQAS = enemyQAS;
        this.handle = (EnemyQueryHandle) queryVC.getHandle();
    }
    
    public EnemyQueryEnemyAreaView makeView(int x, int y){
        view = new EnemyQueryEnemyAreaView(x, y);
        view.add(enemyQAS.getFocusableText());
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){}//TODO
    
    public EnemyQueryHandle getHandle(){
        return handle;
    }
    
}
