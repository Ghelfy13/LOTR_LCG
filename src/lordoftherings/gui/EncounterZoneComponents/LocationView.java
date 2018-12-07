//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class LocationView extends JPanel{
        
    public LocationView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(ActiveLocationView.PARENT_WIDTH), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setOpaque(false);
        setLayout(null);
    }
    
}
