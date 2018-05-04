//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author Amanda
 */
public class EnemyDamageView extends JTextArea{
    public static final int DAMAGE_WIDTH = 180;
    public static final int DAMAGE_HEIGHT = 25;
    
    public EnemyDamageView(int x, int y, int damage){
        this.setBounds(x, y, DAMAGE_WIDTH, DAMAGE_HEIGHT);
        this.insert("Damage: " + damage, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 16);
        this.setFont(cardFont);
        this.setBackground(Color.yellow);
    }
}
