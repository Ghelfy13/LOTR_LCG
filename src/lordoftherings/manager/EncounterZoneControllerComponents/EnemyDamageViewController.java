//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;

/**
 *
 * @author Amanda
 */
public class EnemyDamageViewController {
    
    private EnemyDamageView view;
    protected int damage;
    private GameConfiguration config;
    
    public EnemyDamageViewController(GameConfiguration config){
        damage = 0;
        this.config = config;
    }
    
    public EnemyDamageView makeView(int x, int y){
        view = new EnemyDamageView(x, y, damage, config);
        view.setVisible(true);
        return view;
    }

    public void updateView(int damage) {
        view.setText("Damage: " + damage);
    }
}
