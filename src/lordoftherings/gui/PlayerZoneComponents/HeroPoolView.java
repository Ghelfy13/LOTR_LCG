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
public class HeroPoolView extends JTextArea {
    
    public HeroPoolView (int x, int y, int resources, int damage){
        super("Resources: " + resources + "  Damage: " +damage);
        this.setBounds(x, y, HandCardView.CARD_WIDTH, EnemyDamageView.DAMAGE_HEIGHT);
        this.setFont(AllyCardView.CARD_FONT);
        this.setEditable(false);
        this.setBackground(Color.yellow);
    }
}
