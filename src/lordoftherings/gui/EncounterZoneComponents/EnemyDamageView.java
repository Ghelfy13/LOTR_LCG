//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyDamageView extends JTextArea{
    public static final int DAMAGE_HEIGHT = 25;
    
    public EnemyDamageView(int x, int y, int damage){
        this.setBounds(x, y, HandCardView.CARD_WIDTH, DAMAGE_HEIGHT);
        this.insert("Damage: " + damage, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 12);
        this.setFont(cardFont);
        this.setBackground(Color.yellow);
    }
}
