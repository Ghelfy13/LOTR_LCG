//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public abstract class QueryView extends JPanel{
    public static final int QUERY_WIDTH = scale(2495);
    public static final int QUERY_HEIGHT = scale(1250);
    
    public QueryView(){
        setBounds(0, 0, QUERY_WIDTH, QUERY_HEIGHT);
        setOpaque(false);
        setLayout(null);
    }
}
