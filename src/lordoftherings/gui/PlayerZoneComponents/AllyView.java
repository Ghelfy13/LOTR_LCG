//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class AllyView extends JPanel {
    public static final int VIEW_WIDTH = 205;
    public static final int VIEW_HEIGHT = 225;
    
    public AllyView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(VIEW_WIDTH), config.scale(VIEW_HEIGHT));
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
        setOpaque(true);
    }
}
