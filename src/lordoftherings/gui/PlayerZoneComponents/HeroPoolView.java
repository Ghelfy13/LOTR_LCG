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
public class HeroPoolView extends JTextArea {
    
    public HeroPoolView (int x, int y, int resources, int damage, GameConfiguration config){
        super("Resources: " + resources + "  Damage: " +damage);
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(EnemyDamageView.DAMAGE_HEIGHT));
        this.setFont(config.getFonts().getCardFont());
        this.setEditable(false);
        this.setBackground(Color.yellow);
    }
}
