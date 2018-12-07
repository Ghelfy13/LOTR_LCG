//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import static lordoftherings.gui.PlayerZoneComponents.AllyZoneView.ALLY_ZONE_HEIGHT;
import static lordoftherings.gui.PlayerZoneComponents.AllyZoneView.ALLY_ZONE_WIDTH;

/**
 *
 * @author Amanda
 */
public class QueryAllyZoneView extends JPanel{
    
    public QueryAllyZoneView(int x, int y, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(ALLY_ZONE_WIDTH), config.scale(ALLY_ZONE_HEIGHT));
        this.setOpaque(false);
        this.setLayout(null);
    }
}
