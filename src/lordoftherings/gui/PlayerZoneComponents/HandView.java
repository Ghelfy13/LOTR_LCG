//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
/**
 *
 * @author Amanda
 */
public class HandView extends JPanel{
    
    public HandView(int x, int y, GameConfiguration config){
        setLayout(null);
        setBounds(config.scale(x), config.scale(y), config.scale(EngagementAreaView.AREA_WIDTH), config.scale(HandCardView.CARD_HEIGHT));
        setOpaque(false);
    }
    
   

    
}
