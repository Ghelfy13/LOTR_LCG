//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QueryHeroView extends JPanel{
       
    public QueryHeroView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_HEIGHT), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
        setOpaque(true);
    }
}
