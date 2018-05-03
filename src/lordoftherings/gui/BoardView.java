//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;
import javax.swing.JPanel;



/**
 *
 * @author Amanda
 */
public class BoardView extends JPanel{
    private PlayerZoneView playerZoneView;
    
    public BoardView(int x, int y, int height, int width){
        this.setBounds(x, y, height, width);
        this.setLayout(null);
        this.setOpaque(false);
    }
}
