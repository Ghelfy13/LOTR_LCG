//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class LocationView extends JPanel{
        
    public LocationView(int x, int y){
        setBounds(x, y, scale(ActiveLocationView.PARENT_WIDTH), scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setOpaque(false);
        setLayout(null);
    }
    
}
