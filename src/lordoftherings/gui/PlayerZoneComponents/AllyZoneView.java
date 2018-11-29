//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class AllyZoneView extends JPanel{
    public static final int ALLY_ZONE_WIDTH = scale(600);
    public static final int ALLY_ZONE_HEIGHT = scale(225);
    
    public AllyZoneView(int x, int y){
        this.setBounds(scale(x), scale(y), ALLY_ZONE_WIDTH, ALLY_ZONE_HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
