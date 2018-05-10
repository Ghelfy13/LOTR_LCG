//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class LocationAreaView extends JPanel{
    private int length;
    
    public LocationAreaView (int x, int y, int numOfLocations, MouseMotionListener mmListener){
        length = numOfLocations*(ActiveLocationView.PARENT_WIDTH);
        setBounds(x, y, length, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.CYAN);
        this.addMouseMotionListener(mmListener);
    }
    
    public int getLength(){
        return length;
    }
}
