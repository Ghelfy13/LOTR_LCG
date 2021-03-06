//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;
import static lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView.CARD_BORDER;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class VictoryPointsPileView extends JPanel{
    public static final int PILE_WIDTH = HandCardView.CARD_WIDTH + 
            EncounterDiscardPileView.CARD_BORDER;
    public static final int PILE_HEIGHT = HandCardView.CARD_HEIGHT + CARD_BORDER;
    
    public VictoryPointsPileView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(PILE_WIDTH), 
                config.scale(PILE_HEIGHT));
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
