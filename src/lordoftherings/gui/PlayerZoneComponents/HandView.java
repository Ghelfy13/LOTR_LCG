//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class HandView extends JPanel{
    
    public HandView(int x, int y){
        setLayout(null);
        setBounds(x,y, 1250, 280);
        setOpaque(true);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
    }
    
   

    
}
