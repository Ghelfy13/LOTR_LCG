//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyAreaView extends JPanel{
    
    public EnemyQueryEnemyAreaView(int x, int y, int numOfEnemies){
        setLayout(null);
        setBounds(x, y, numOfEnemies*ActiveLocationView.PARENT_WIDTH, 
                HandCardView.CARD_HEIGHT);
        setOpaque(false);
        //setBackground(Color.white);
    }
}
