//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class PlayerZoneView extends JPanel {
    public static final int ZONE_WIDTH = scale(2400);
    public static final int ZONE_HEIGHT = scale(700);
    
    public PlayerZoneView(int x, int y){
        setLayout(null);
        setBounds(scale(x), scale(y), ZONE_WIDTH, ZONE_HEIGHT);
        setOpaque(false);
    }
}
