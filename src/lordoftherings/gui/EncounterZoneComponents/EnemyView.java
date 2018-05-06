//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.manager.EncounterZoneControllerComponents.EnemyViewController;

/**
 *
 * @author Amanda
 */
public class EnemyView extends JPanel{
    
    public static final int ENEMY_WIDTH = 200;
    public static final int ENEMY_HEIGHT = 275;
    
    public EnemyView(EnemyViewController controller, int x, int y){
        setBounds(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.ORANGE);
        
    }
}
