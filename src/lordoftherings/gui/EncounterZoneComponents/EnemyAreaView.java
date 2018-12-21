//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class EnemyAreaView extends JPanel{
    private int length;
    
    public EnemyAreaView(int x, int y, int numOfEnemies, MouseMotionListener mmListener, GameConfiguration config){
        length = numOfEnemies*ActiveLocationView.PARENT_WIDTH;
        setBounds(config.scale(x), config.scale(y), config.scale(length),
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(true);
        this.addMouseMotionListener(mmListener);
        
    }
    
    public int getLengthOfEnemyArea(){
        return length;
    }
}
