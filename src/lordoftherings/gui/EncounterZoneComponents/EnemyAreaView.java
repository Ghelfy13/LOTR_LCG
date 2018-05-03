//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class EnemyAreaView extends JPanel{
    private int length;
    
    public EnemyAreaView(int x, int y, int numOfEnemies, MouseMotionListener mmListener){
        //length = numOfEnemies*250;
        length = 250*5;//TODO: GO BACK TO CALCULATION VIEW
        setBounds(x, y, length, 275);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        this.addMouseMotionListener(mmListener);
    }
    
    public int getLengthOfEnemyArea(){
        return length;
    }
}
