//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;

/**
 *
 * @author Amanda
 */
public class DiscardPileView extends JPanel{
    public static final int D_PILE_WIDTH = HandCardView.CARD_WIDTH + 
            EncounterDiscardPileView.CARD_BORDER;
    public static final int D_PILE_HEIGHT = HandCardView.CARD_HEIGHT + 
            EncounterDiscardPileView.CARD_BORDER;
      
    public DiscardPileView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(D_PILE_WIDTH),
                config.scale(D_PILE_HEIGHT));
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
