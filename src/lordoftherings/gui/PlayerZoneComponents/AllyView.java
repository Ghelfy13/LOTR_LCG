//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class AllyView extends JPanel {
    public static final int VIEW_WIDTH = scale(205);
    public static final int VIEW_HEIGHT = scale(225);
    
    public AllyView(int x, int y){
        setBounds(scale(x), scale(y), VIEW_WIDTH, VIEW_HEIGHT);
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
        setOpaque(true);
    }
}
