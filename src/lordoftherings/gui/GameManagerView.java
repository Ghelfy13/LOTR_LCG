//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import static lordoftherings.GameConfiguration.scale;
import javax.swing.JLayeredPane;

/**
 *
 * @author Amanda
 */
public class GameManagerView extends JLayeredPane{
     public static final int WINDOW_WIDTH = 2500;
    public static final int WINDOW_LENGTH = 1300;
    
    public GameManagerView(int x, int y){
        setBounds(x, y, scale(WINDOW_WIDTH), scale(WINDOW_LENGTH));
        setLayout(null);
        setOpaque(false);
    }
}
