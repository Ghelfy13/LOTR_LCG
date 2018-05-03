//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class LocationAreaView extends JPanel{
    private int length;
    
    public LocationAreaView (int x, int y, int numOfLocations, MouseMotionListener mmListener){
        length = numOfLocations*200;
        setBounds(x, y, length, 275);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.CYAN);
        this.addMouseMotionListener(mmListener);
    }
    
    public int getLength(){
        return length;
    }
}
