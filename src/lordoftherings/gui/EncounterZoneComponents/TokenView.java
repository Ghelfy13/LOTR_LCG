//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class TokenView extends JTextArea{
    
     
    public TokenView(int x, int y, int tokenNum, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), config.scale(EnemyDamageView.DAMAGE_HEIGHT));
        this.insert("Tokens: " + tokenNum, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.yellow);
    }
}
