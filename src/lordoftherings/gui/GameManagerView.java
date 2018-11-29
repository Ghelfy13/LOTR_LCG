//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import static lordoftherings.GameConfiguration.scale;
import javax.swing.JLayeredPane;

/**
 *
 * @author Amanda
 */
public class GameManagerView extends JLayeredPane{
     public static final int WINDOW_WIDTH = scale(2500);
    public static final int WINDOW_LENGTH = scale(1300);
    
    public GameManagerView(int x, int y){
        setBounds(scale(x), scale(y), WINDOW_WIDTH, WINDOW_LENGTH);
        setLayout(null);
        setOpaque(false);
    }
}
