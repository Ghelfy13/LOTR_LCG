//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import static lordoftherings.gui.GameManagerView.WINDOW_LENGTH;
import static lordoftherings.gui.GameManagerView.WINDOW_WIDTH;



/**
 *
 * @author Amanda
 */
public class BoardView extends JPanel{
    
    public BoardView(int x, int y, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(WINDOW_WIDTH), config.scale(WINDOW_LENGTH));
        this.setLayout(null);
        this.setOpaque(false);
    }
}
