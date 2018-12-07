//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;

/**
 *
 * @author Amanda
 */
public class AllyDamageView extends JTextArea {
    
    public AllyDamageView (int x, int y, int damage, GameConfiguration config){
        super("Damage: " +damage);
        this.setBounds(config.scale(x), config.scale(y), config.scale(HandCardView.CARD_WIDTH), config.scale(EnemyDamageView.DAMAGE_HEIGHT));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setEditable(false);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.yellow);
    }
}
