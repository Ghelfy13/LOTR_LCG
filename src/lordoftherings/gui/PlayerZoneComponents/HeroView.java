//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;

/**
 *
 * @author Amanda
 */
public class HeroView extends JPanel{
        
    public HeroView(int x, int y){
        setBounds(scale(x), scale(y), HandCardView.CARD_HEIGHT,
                ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(false);
    }
}
