//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class PlayerZoneView extends JPanel {
    public final int ZONE_WIDTH = 2400;
    public final int ZONE_HEIGHT = 700;
    
    public PlayerZoneView(int x, int y){
        setLayout(null);
        setBounds(x, y, ZONE_WIDTH, ZONE_HEIGHT);
        setOpaque(false);
    }
}
