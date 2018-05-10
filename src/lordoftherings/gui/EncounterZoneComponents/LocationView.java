//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class LocationView extends JPanel{
        
    public LocationView(int x, int y){
        setBounds(x, y, ActiveLocationView.PARENT_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setOpaque(false);
        setLayout(null);
    }
    
}
