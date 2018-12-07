//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class LocationAreaView extends JPanel{
    private int length;
    
    public LocationAreaView (int x, int y, int numOfLocations, 
            MouseMotionListener mmListener, GameConfiguration config){
        length = numOfLocations*(ActiveLocationView.PARENT_WIDTH);
        setBounds(config.scale(x), config.scale(y), config.scale(length), config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(false);
        this.addMouseMotionListener(mmListener);
    }
    
    public int getLength(){
        return length;
    }
}
