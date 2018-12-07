//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;


/**
 *
 * @author Amanda
 */
public class QueryAllyDamageView extends JTextArea{
    
    public QueryAllyDamageView (int x, int y, int damage, GameConfiguration config){
        super("Damage: " +damage);
        this.setBounds(config.scale(x), config.scale(y), config.scale(HandCardView.CARD_WIDTH), config.scale(EnemyDamageView.DAMAGE_HEIGHT));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setEditable(false);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.yellow);
    }
}
