//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class CharacterAreaView extends JPanel{
    
    public CharacterAreaView(int x, int y, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y),
                config.scale(EncounterZoneView.ZONE_WIDTH), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        this.setOpaque(false);
        this.setLayout(null);
    }
}
