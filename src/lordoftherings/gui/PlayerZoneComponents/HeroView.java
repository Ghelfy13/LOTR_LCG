//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;

/**
 *
 * @author Amanda
 */
public class HeroView extends JPanel{
        
    public HeroView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_HEIGHT),
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(false);
    }
}
