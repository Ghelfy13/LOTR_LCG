//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.characters.Enemy;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.manager.actionComponents.SelectableActiveState;

/**
 *
 * @author Amanda
 */
public class EnemyQueryActiveState extends SelectableActiveState<Enemy> {

    private EnemyQueryViewController enemyQueryVC;
    
    public EnemyQueryActiveState(EnemyQueryViewController enemyQueryVC){
        super(enemyQueryVC);
        this.enemyQueryVC = enemyQueryVC;
    }
    
    @Override
    public void selectOrDeselect(Selectable<Enemy> selectedElement) {
        
    }
    
}
