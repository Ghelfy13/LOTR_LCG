//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;

/**
 *
 * @author Amanda
 */
public class EngagementAreaView extends JPanel{
    public static final int AREA_WIDTH = scale(1400);
    
    public EngagementAreaView(int x, int y, int numOfEnemies){
        setBounds(scale(x), scale(y), AREA_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(false);
    }
}
