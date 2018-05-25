//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author Amanda
 */
public class AllyCardView extends JTextArea{
    public static final Font CARD_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 12);
    
    public AllyCardView(String heroInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(heroInfo, 0);
        this.setFont(CARD_FONT);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(x, y, HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
        
    }
}
