//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class QueryPlayerZoneView extends JPanel{
    public static final int ZONE_WIDTH = 2000;
    public static final int ZONE_HEIGHT =1000;
    
    public QueryPlayerZoneView(int x, int y, GameConfiguration config){
        setLayout(null);
        setBounds(config.scale(x), config.scale(y), config.scale(ZONE_WIDTH), 
                config.scale(ZONE_HEIGHT));
        setOpaque(false);
        setVisible(true);
    }
    
}
