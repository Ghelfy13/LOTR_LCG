//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class QueryPlayerZoneView extends JPanel{
    public final int ZONE_WIDTH = 2000;
    public final int ZONE_HEIGHT = 1000;
    
    public QueryPlayerZoneView(int x, int y){
        setLayout(null);
        setBounds(x, y, ZONE_WIDTH, ZONE_HEIGHT);
        setOpaque(false);
    }
    
}
