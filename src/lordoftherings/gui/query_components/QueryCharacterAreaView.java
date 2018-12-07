//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class QueryCharacterAreaView extends JPanel {
    
    public QueryCharacterAreaView(int x, int y, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(EncounterZoneView.ZONE_WIDTH), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        //Color backgroundColor = new Color(0x10,0x66,0x1b);
        //setBackground(Color.white);
        //this.setBackground(backgroundColor);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
