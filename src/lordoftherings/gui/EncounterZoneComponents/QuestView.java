//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QuestView extends JPanel{
    
    public QuestView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(HandCardView.CARD_HEIGHT), 
                config.scale(HandCardView.CARD_WIDTH + EnemyDamageView.DAMAGE_HEIGHT));
        setLayout(null);
        setOpaque(true);
        
    }
}
