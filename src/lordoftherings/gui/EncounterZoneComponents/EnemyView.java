//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import lordoftherings.manager.EncounterZoneControllerComponents.EnemyViewController;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class EnemyView extends JPanel{
    
    public EnemyView(EnemyViewController controller, int x, int y){
        setBounds(x, y, scale(ActiveLocationView.PARENT_WIDTH),
                scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(false);
        
    }
}
