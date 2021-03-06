//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.AllyView;

/**
 *
 * @author Amanda
 */
public class QueryAllyView extends JPanel{
        
    public QueryAllyView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(AllyView.VIEW_WIDTH), 
                config.scale(AllyView.VIEW_HEIGHT));
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
        setOpaque(true);
    }
}
