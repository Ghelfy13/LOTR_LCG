//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class EngagementAreaView extends JPanel{
    public static final int AREA_WIDTH = 200*7;
    
    public EngagementAreaView(int x, int y, int numOfEnemies){
        setBounds(x, y, AREA_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.PINK);
    }
}
