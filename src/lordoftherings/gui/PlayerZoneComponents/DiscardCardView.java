//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author Amanda
 */
public class DiscardCardView extends JTextArea{
    private static final int CARD_WIDTH = 180;
    private static final int CARD_HEIGHT = 250;
    
    public DiscardCardView(int x, int y, String info){
        setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
        setText(info);
        setOpaque(true);
        setLayout(null);
        setEditable(false);
        setBackground(Color.LIGHT_GRAY);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 14);
        setFont(cardFont);
    }
}
