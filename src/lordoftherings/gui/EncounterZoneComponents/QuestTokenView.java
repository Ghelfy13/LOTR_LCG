//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QuestTokenView extends JTextArea{
     
    public QuestTokenView(int x, int y, int tokenNum){
        this.setBounds(scale(x), scale(y), HandCardView.CARD_HEIGHT, EnemyDamageView.DAMAGE_HEIGHT);
        this.insert("Tokens: " + tokenNum, 0);
        this.setEditable(false);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setFont(AllyCardView.CARD_FONT);
        this.setBackground(Color.yellow);
    }
}