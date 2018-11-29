//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QuestView extends JPanel{
    
    public QuestView(int x, int y){
        setBounds(scale(x), scale(y), HandCardView.CARD_HEIGHT, HandCardView.CARD_WIDTH + EnemyDamageView.DAMAGE_HEIGHT);
        setLayout(null);
        setOpaque(true);
        
    }
}
