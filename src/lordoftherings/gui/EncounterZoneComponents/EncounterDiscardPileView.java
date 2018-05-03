//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardPileView extends JPanel{
    
    private static final int CARD_WIDTH = 180;
    private static final int CARD_HEIGHT = 250;
    
    public EncounterDiscardPileView(int x, int y){
        setBounds(x, y, CARD_WIDTH +10, CARD_HEIGHT + 10);
        setOpaque(true);
        setLayout(null);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
