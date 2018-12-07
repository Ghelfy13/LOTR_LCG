//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyAreaView extends JPanel{
    
    public EnemyQueryEnemyAreaView(int x, int y, int numOfEnemies, 
            GameConfiguration config){
        setLayout(null);
        setBounds(config.scale(x), config.scale(y), 
                config.scale(numOfEnemies*ActiveLocationView.PARENT_WIDTH), 
                config.scale(HandCardView.CARD_HEIGHT));
        setOpaque(false);
        //setBackground(Color.white);
    }
}
