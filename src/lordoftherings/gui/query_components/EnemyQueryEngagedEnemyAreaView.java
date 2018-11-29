//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import static lordoftherings.gui.PlayerZoneComponents.EngagementAreaView.AREA_WIDTH;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEngagedEnemyAreaView extends JPanel{
    
    public EnemyQueryEngagedEnemyAreaView(int x, int y, int numOfEnemies){
        setLayout(null);
        setBounds(scale(x), scale(y), AREA_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setOpaque(false);
    }
}
