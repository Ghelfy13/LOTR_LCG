//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author Amanda
 */
public class HeroPoolView extends JTextArea {
    
    public HeroPoolView (int x, int y, int resources, int damage){
        super("Resources: " + resources + "  Damage: " +damage);
        this.setBounds(x, y, 180, 25);
        this.setEditable(false);
        this.setBackground(Color.yellow);
    }
}
