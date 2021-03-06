//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class AllyZoneView extends JPanel{
    public static final int ALLY_ZONE_WIDTH = 600;
    public static final int ALLY_ZONE_HEIGHT = 225;
    
    public AllyZoneView(int x, int y, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y),
                config.scale(ALLY_ZONE_WIDTH), config.scale(ALLY_ZONE_HEIGHT));
        this.setOpaque(false);
        this.setLayout(null);
    }
}
