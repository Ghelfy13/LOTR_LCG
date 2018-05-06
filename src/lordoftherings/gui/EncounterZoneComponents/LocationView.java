//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class LocationView extends JPanel{
    public static final int LOCATION_WIDTH = 200;
    public static final int LOCATION_HEIGHT = 275;
    
    public LocationView(int x, int y){
        setBounds(x, y, LOCATION_WIDTH, LOCATION_HEIGHT);
        setOpaque(false);
        setLayout(null);
    }
    
}
