//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public abstract class QueryView extends JPanel{
    public static final int QUERY_WIDTH = 2495;
    public static final int QUERY_HEIGHT = 1250;
    
    public QueryView(GameConfiguration config){
        setBounds(0, 0, config.scale(QUERY_WIDTH), config.scale(QUERY_HEIGHT));
        setOpaque(false);
        setLayout(null);
    }
}
