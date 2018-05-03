//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class QueryAllyView extends JPanel{
    public static final int VIEW_WIDTH = 255;
    public static final int VIEW_HEIGHT = 275;
    
    public QueryAllyView(int x, int y){
        setBounds(x, y, VIEW_WIDTH, VIEW_HEIGHT);
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
        setOpaque(true);
    }
}
