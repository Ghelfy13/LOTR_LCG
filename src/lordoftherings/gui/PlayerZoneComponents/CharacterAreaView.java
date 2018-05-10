//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class CharacterAreaView extends JPanel{
    
    public CharacterAreaView(int x, int y){
        this.setBounds(x, y, EncounterZoneView.ZONE_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
