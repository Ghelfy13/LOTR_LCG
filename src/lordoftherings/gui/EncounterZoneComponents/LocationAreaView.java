//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class LocationAreaView extends JPanel{
    private int length;
    
    public LocationAreaView (int x, int y, int numOfLocations, MouseMotionListener mmListener){
        length = numOfLocations*(ActiveLocationView.PARENT_WIDTH);
        setBounds(scale(x), scale(y), length, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(false);
        this.addMouseMotionListener(mmListener);
    }
    
    public int getLength(){
        return length;
    }
}
