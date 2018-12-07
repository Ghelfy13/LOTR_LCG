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
public class EnemyCardView extends JTextArea{
    
    public EnemyCardView(String enemyInfo, int x, int y, GameConfiguration config){
        this.setRows(11);
        this.setColumns(1);
        this.insert(enemyInfo, 0);
        this.setFont(config.getFonts().getCardFont());
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), config.scale(HandCardView.CARD_HEIGHT));
        
    }
}
