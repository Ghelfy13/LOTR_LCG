//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;

/**
 *
 * @author Amanda
 */
public class AllyDamageView extends JTextArea {
    
    public AllyDamageView (int x, int y, int damage){
        super("Damage: " +damage);
        this.setBounds(x, y, HandCardView.CARD_WIDTH, EnemyDamageView.DAMAGE_HEIGHT);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setEditable(false);
        this.setFont(AllyCardView.CARD_FONT);
        this.setBackground(Color.yellow);
    }
}
