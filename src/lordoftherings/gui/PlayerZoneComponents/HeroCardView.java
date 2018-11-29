//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class HeroCardView extends JTextArea{
       
    public HeroCardView(String heroInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(heroInfo, 0);
        this.setFont(AllyCardView.CARD_FONT);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(scale(x), scale(y), HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
    }
}
