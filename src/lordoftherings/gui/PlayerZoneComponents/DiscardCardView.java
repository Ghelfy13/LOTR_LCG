//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class DiscardCardView extends JTextArea{
        
    public DiscardCardView(int x, int y, String info, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(HandCardView.CARD_HEIGHT));
        setText(info);
        setOpaque(true);
        setLayout(null);
        setEditable(false);
        setBackground(Color.LIGHT_GRAY);
        setFont(config.getFonts().getCardFont());
    }
}
