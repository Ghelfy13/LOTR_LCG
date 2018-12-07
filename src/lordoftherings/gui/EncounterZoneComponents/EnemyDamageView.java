//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyDamageView extends JTextArea{
    public static final int DAMAGE_HEIGHT = 18;
    
    public EnemyDamageView(int x, int y, int damage, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), config.scale(DAMAGE_HEIGHT));
        this.insert("Damage: " + damage, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.yellow);
    }
}
