//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;

/**
 *
 * @author Amanda
 */
public class EngagementAreaView extends JPanel{
    public static final int AREA_WIDTH = 1400;
    
    public EngagementAreaView(int x, int y, int numOfEnemies, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(AREA_WIDTH), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(false);
    }
}
