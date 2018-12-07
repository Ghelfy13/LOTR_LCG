//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPlayerZoneView extends JPanel{
    
    public DiscardPileQueryPlayerZoneView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(QueryPlayerZoneView.ZONE_WIDTH), 
                config.scale(QueryPlayerZoneView.ZONE_HEIGHT));
        setLayout(null);
        setOpaque(false);
        setVisible(true);
    }
}
