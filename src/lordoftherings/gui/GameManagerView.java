//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import javax.swing.JLayeredPane;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class GameManagerView extends JLayeredPane{
     public static final int WINDOW_WIDTH = 2500;
    public static final int WINDOW_LENGTH = 1300;
    
    public GameManagerView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(WINDOW_WIDTH), 
                config.scale(WINDOW_LENGTH));
        setLayout(null);
        setOpaque(false);
    }
}
