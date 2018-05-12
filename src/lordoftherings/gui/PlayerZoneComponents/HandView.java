//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
/**
 *
 * @author Amanda
 */
public class HandView extends JPanel{
    
    public HandView(int x, int y){
        setLayout(null);
        setBounds(x,y, EngagementAreaView.AREA_WIDTH, HandCardView.CARD_HEIGHT);
        setOpaque(false);
    }
    
   

    
}
