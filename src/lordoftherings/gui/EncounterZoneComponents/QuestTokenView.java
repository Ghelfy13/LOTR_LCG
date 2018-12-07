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
public class QuestTokenView extends JTextArea{
    
     
    public QuestTokenView(int x, int y, int tokenNum, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), config.scale(HandCardView.CARD_HEIGHT),
                config.scale(EnemyDamageView.DAMAGE_HEIGHT));
        this.insert("Tokens: " + tokenNum, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.yellow);
    }
}