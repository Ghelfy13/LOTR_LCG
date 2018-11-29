//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
/**
 *
 * @author Amanda
 */
public class ActiveLocationView extends JPanel{
    public static final int CARD_COUNTER_HEIGHT = 225;
    public static final int PARENT_WIDTH = 160;
    
    public ActiveLocationView(int x, int y){
        setBounds(x, y, scale(PARENT_WIDTH), scale(CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setBackground(Color.MAGENTA);
    }
}
