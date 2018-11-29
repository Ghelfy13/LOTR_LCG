//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardPileView extends JPanel{
    public static final int CARD_BORDER = scale(10);
    
    public EncounterDiscardPileView(int x, int y){
        setBounds(scale(x), scale(y), HandCardView.CARD_WIDTH + CARD_BORDER,
                HandCardView.CARD_HEIGHT + CARD_BORDER);
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
