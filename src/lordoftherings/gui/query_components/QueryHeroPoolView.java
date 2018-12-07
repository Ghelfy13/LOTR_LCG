//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QueryHeroPoolView extends JTextArea{
    
    public QueryHeroPoolView (int x, int y, int resources, int damage,
            GameConfiguration config){
        super("Resources: " + resources + "  Damage: " +damage);
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(EnemyDamageView.DAMAGE_HEIGHT));
        this.setFont(config.getFonts().getCardFont());
        this.setEditable(false);
        this.setBackground(Color.yellow);
    }
}
