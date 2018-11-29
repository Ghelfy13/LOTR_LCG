//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QueryPlayerZoneView extends JPanel{
    public static final int ZONE_WIDTH = scale(2000);
    public static final int ZONE_HEIGHT = scale(1000);
    
    public QueryPlayerZoneView(int x, int y){
        setLayout(null);
        setBounds(scale(x), scale(y), ZONE_WIDTH, ZONE_HEIGHT);
        setOpaque(false);
        setVisible(true);
    }
    
}
