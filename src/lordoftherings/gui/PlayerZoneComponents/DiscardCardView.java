//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class DiscardCardView extends JTextArea{
        
    public DiscardCardView(int x, int y, String info){
        setBounds(scale(x), scale(y), HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
        setText(info);
        setOpaque(true);
        setLayout(null);
        setEditable(false);
        setBackground(Color.LIGHT_GRAY);
        setFont(AllyCardView.CARD_FONT);
    }
}
