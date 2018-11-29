//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;

/**
 *
 * @author Amanda
 */
public class DiscardPileView extends JPanel{
      
    public DiscardPileView(int x, int y){
        setBounds(scale(x), scale(y), HandCardView.CARD_WIDTH + EncounterDiscardPileView.CARD_BORDER,
                HandCardView.CARD_HEIGHT + EncounterDiscardPileView.CARD_BORDER);
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
