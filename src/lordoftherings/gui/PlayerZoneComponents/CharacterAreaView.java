//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class CharacterAreaView extends JPanel{
    
    public CharacterAreaView(int x, int y){
        this.setBounds(scale(x), scale(y), EncounterZoneView.ZONE_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
