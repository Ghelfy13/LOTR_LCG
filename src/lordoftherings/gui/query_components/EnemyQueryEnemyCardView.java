//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyCardView extends JTextArea{
    
    public EnemyQueryEnemyCardView(String enemyInfo, GameConfiguration config){
        setBounds(0, 0, config.scale(HandCardView.CARD_WIDTH),
                config.scale(HandCardView.CARD_HEIGHT));
        this.setEditable(false);
        this.insert(enemyInfo,0);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.LIGHT_GRAY);
    }
}
