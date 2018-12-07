//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardCardView extends JTextArea{
    
    public EncounterDiscardCardView(int x, int y, String info, GameConfiguration config){
        setText(info);
        setOpaque(true);
        setLayout(null);
        setEditable(false);
        setBackground(Color.LIGHT_GRAY);
        setFont(config.getFonts().getCardFont());
        setBounds(config.scale(x), config.scale(y), config.scale(HandCardView.CARD_WIDTH), config.scale(HandCardView.CARD_HEIGHT));
    }
}
