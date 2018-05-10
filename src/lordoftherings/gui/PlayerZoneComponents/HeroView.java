//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;

/**
 *
 * @author Amanda
 */
public class HeroView extends JPanel{
        
    public HeroView(int x, int y){
        setBounds(x, y, HandCardView.CARD_HEIGHT,
                ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}
