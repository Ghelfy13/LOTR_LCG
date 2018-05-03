//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class CharacterAreaView extends JPanel{
    
    public CharacterAreaView(int x, int y){
        this.setBounds(x, y, 1600, 300);
        //setBackground(Color.white);
        this.setOpaque(false);
        this.setLayout(null);
    }
}
