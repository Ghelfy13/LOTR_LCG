//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class LocationTokenView extends JTextArea{
     
    public LocationTokenView(int x, int y, int tokenNum){
        this.setBounds(x, y, HandCardView.CARD_WIDTH, EnemyDamageView.DAMAGE_HEIGHT);
        this.insert("Tokens: " + tokenNum, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 12);
        this.setFont(cardFont);
        this.setBackground(Color.yellow);
    }
}
