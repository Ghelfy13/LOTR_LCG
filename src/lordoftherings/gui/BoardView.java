//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;
import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import static lordoftherings.gui.GameManagerView.WINDOW_LENGTH;
import static lordoftherings.gui.GameManagerView.WINDOW_WIDTH;



/**
 *
 * @author Amanda
 */
public class BoardView extends JPanel{
    
    public BoardView(int x, int y){
        this.setBounds(scale(x), scale(y), WINDOW_WIDTH, WINDOW_LENGTH);
        this.setLayout(null);
        this.setOpaque(false);
    }
}
