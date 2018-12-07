//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
/**
 *
 * @author Amanda
 */
public class ActiveLocationView extends JPanel{
    public static final int CARD_COUNTER_HEIGHT = 225;
    public static final int PARENT_WIDTH = 160;
    
    public ActiveLocationView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(PARENT_WIDTH), 
                config.scale(CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setBackground(Color.MAGENTA);
    }
}
