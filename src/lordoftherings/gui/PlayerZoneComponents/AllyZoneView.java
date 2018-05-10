//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class AllyZoneView extends JPanel{
    public static final int ALLY_ZONE_WIDTH = 600;
    public static final int ALLY_ZONE_HEIGHT = 225;
    
    public AllyZoneView(int x_Value, int y_Value){
        this.setBounds(x_Value,y_Value, ALLY_ZONE_WIDTH, ALLY_ZONE_HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
