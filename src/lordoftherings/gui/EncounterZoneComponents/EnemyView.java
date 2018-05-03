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
    
    public EnemyView(EnemyViewController controller, int x, int y){
        setBounds(x, y, 255, 275);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.ORANGE);
        
    }
}
