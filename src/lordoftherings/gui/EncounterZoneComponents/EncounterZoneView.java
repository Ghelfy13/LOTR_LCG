//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController;

/**
 *
 * @author Amanda
 */
public class EncounterZoneView extends JPanel {
    public static final int ZONE_WIDTH = 2000;
    public static final int ZONE_HEIGHT =  2*ActiveLocationView.CARD_COUNTER_HEIGHT +
                EncounterZoneViewController.DISTANCE_FROM_FRAME;
    
    public EncounterZoneView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(ZONE_WIDTH), config.scale(ZONE_HEIGHT));
        setLayout(null);
        setOpaque(false);
    }
}
