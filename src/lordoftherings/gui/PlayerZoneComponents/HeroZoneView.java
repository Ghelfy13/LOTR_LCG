//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JPanel;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;

/**
 *
 * @author Amanda
 */
public class HeroZoneView extends JPanel{
    private int length;
    
    public HeroZoneView(int x, int y, int numOfHeros){
        length = numOfHeros*205;
        setBounds(x, y, length ,ActiveLocationView.CARD_COUNTER_HEIGHT);
        setOpaque(true);
        setBackground(Color.CYAN);
        setLayout(null);
    }
    
    public int getLengthOfHeroZone(){
        return length;
    }

    
}
