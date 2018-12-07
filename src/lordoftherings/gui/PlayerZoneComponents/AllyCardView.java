//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class AllyCardView extends JTextArea{
    
    public AllyCardView(String heroInfo, int x, int y, GameConfiguration config){
        this.setRows(11);
        this.setColumns(1);
        this.insert(heroInfo, 0);
        this.setFont(config.getFonts().getCardFont());
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(HandCardView.CARD_HEIGHT));
        
    }
    
}
