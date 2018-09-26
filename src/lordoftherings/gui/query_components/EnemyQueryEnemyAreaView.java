//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyAreaView extends JPanel{
    
    public EnemyQueryEnemyAreaView(int x, int y){
        setLayout(null);
        setBounds(x, y, EncounterZoneView.ZONE_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setOpaque(true);
        setBackground(Color.white);
    }
}
