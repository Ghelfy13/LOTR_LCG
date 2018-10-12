//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class EnemyAreaView extends JPanel{
    private int length;
    
    public EnemyAreaView(int x, int y, int numOfEnemies, MouseMotionListener mmListener){
        length = numOfEnemies*ActiveLocationView.PARENT_WIDTH;
        setBounds(x, y, length, HandCardView.CARD_HEIGHT);
        setLayout(null);
        setOpaque(false);
        this.addMouseMotionListener(mmListener);
    }
    
    public int getLengthOfEnemyArea(){
        return length;
    }
}
