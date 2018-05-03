//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class HeroZoneView extends JPanel{
    private int length;
    
    public HeroZoneView(int x, int y, int numOfHeros){
        length = numOfHeros*255;
        setBounds(x, y, length ,275);
        setOpaque(false);
        setLayout(null);
    }
    
    public int getLengthOfHeroZone(){
        return length;
    }

    
}
