//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardPileView extends JPanel{
    public static final int CARD_BORDER = 10;
    
    public EncounterDiscardPileView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(HandCardView.CARD_WIDTH + CARD_BORDER),
                config.scale(HandCardView.CARD_HEIGHT + CARD_BORDER));
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
