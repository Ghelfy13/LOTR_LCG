//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.JTextArea;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyDamageView extends JTextArea{
    
     public EnemyQueryEnemyDamageView (int x, int y, int damage){
        super("Damage: " +damage);
        this.setBounds(x, y, HandCardView.CARD_WIDTH, EnemyDamageView.DAMAGE_HEIGHT);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setEditable(false);
        this.setFont(AllyCardView.CARD_FONT);
        this.setBackground(Color.yellow);
    }
}
