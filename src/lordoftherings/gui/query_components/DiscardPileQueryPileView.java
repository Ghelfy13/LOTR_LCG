//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPileView extends JPanel{
    
    public DiscardPileQueryPileView(int x, int y){
        setBounds(x, y, HandCardView.CARD_WIDTH + EncounterDiscardPileView.CARD_BORDER,
                HandCardView.CARD_HEIGHT + EncounterDiscardPileView.CARD_BORDER);
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
