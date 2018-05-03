//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class EngagementAreaView extends JPanel{
    public static final int AREA_WIDTH = 270*5;
    public static final int AREA_HEIGHT = 275;
    
    public EngagementAreaView(int x, int y, int numOfEnemies){
        setBounds(x, y, AREA_WIDTH, AREA_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.PINK);
    }
}
