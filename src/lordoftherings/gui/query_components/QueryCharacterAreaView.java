//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class QueryCharacterAreaView extends JPanel {
    
    public QueryCharacterAreaView(int x, int y){
        this.setBounds(scale(x), scale(y), EncounterZoneView.ZONE_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        //Color backgroundColor = new Color(0x10,0x66,0x1b);
        //setBackground(Color.white);
        //this.setBackground(backgroundColor);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
