//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class EncounterZoneView extends JPanel {
    public static final int ZONE_WIDTH = 2000;
    
    public EncounterZoneView(int x, int y){
        setBounds( x, y, ZONE_WIDTH , ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setBackground(Color.YELLOW);
        setOpaque(false);
    }
}
