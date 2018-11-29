//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPlayerZoneView extends JPanel{
    
    public DiscardPileQueryPlayerZoneView(int x, int y){
        setBounds(scale(x), scale(y), QueryPlayerZoneView.ZONE_WIDTH, 
                QueryPlayerZoneView.ZONE_HEIGHT);
        setLayout(null);
        setOpaque(false);
        setVisible(true);
    }
}
