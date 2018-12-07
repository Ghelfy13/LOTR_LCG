//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class PlayerZoneView extends JPanel {
    public static final int ZONE_WIDTH = 2400;
    public static final int ZONE_HEIGHT = 700;
    
    public PlayerZoneView(int x, int y, GameConfiguration config){
        setLayout(null);
        setBounds(config.scale(x), config.scale(y), config.scale(ZONE_WIDTH),
                config.scale(ZONE_HEIGHT));
        setOpaque(false);
    }
}
