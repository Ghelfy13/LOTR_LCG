//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPlayerZoneView extends JPanel{
    
    public DiscardPileQueryPlayerZoneView(int x, int y){
        setBounds(x, y, QueryPlayerZoneView.ZONE_WIDTH, 
                QueryPlayerZoneView.ZONE_HEIGHT);
        setLayout(null);
        setOpaque(false);
        setVisible(true);
    }
}
