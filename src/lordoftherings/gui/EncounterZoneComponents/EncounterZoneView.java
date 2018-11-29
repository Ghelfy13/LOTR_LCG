//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import static lordoftherings.GameConfiguration.scale;
import javax.swing.JPanel;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController;

/**
 *
 * @author Amanda
 */
public class EncounterZoneView extends JPanel {
    public static final int ZONE_WIDTH = 2000;
    
    public EncounterZoneView(int x, int y){
        setBounds( x, y, scale(ZONE_WIDTH), scale(2*ActiveLocationView.CARD_COUNTER_HEIGHT +
                EncounterZoneViewController.DISTANCE_FROM_FRAME));
        setLayout(null);
        setOpaque(false);
    }
}
