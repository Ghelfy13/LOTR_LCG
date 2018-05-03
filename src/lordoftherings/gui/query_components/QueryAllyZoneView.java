//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import static lordoftherings.gui.PlayerZoneComponents.AllyZoneView.ALLY_ZONE_HEIGHT;
import static lordoftherings.gui.PlayerZoneComponents.AllyZoneView.ALLY_ZONE_WIDTH;

/**
 *
 * @author Amanda
 */
public class QueryAllyZoneView extends JPanel{
    
    public QueryAllyZoneView(int x_Value, int y_Value){
        this.setBounds(x_Value,y_Value, ALLY_ZONE_WIDTH, ALLY_ZONE_HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
