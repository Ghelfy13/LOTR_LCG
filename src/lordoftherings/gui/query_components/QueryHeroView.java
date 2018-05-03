//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class QueryHeroView extends JPanel{
    public static final int AREA_WIDTH = 255;
    public static final int AREA_LENGTH = 275;
    
    public QueryHeroView(int x, int y){
        setBounds(x, y, AREA_WIDTH, AREA_LENGTH);
        setLayout(null);
        Color backgroundColor = new Color(0x10,0x66,0x1b);
        setBackground(backgroundColor);
        setOpaque(true);
    }
}
