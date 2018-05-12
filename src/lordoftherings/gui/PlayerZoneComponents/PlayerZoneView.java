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
    public final int ZONE_HEIGHT = 900;
    
    public PlayerZoneView(int x, int y){
        setLayout(null);
        setBounds(x, y, ZONE_WIDTH, ZONE_HEIGHT);
        setOpaque(true);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        //setBackground(backgroundColor);
        setBackground(Color.WHITE);
    }
}
