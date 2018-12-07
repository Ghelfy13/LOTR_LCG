//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import static lordoftherings.gui.PlayerZoneComponents.EngagementAreaView.AREA_WIDTH;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEngagedEnemyAreaView extends JPanel{
    
    public EnemyQueryEngagedEnemyAreaView(int x, int y, int numOfEnemies, GameConfiguration config){
        setLayout(null);
        setBounds(config.scale(x), config.scale(y), config.scale(AREA_WIDTH), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setOpaque(false);
    }
}
