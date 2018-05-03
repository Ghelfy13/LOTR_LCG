//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class ActiveLocationView extends JPanel{
    
    public ActiveLocationView(int x, int y){
        setBounds(x, y, 200, 275);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.MAGENTA);
    }
}
