//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;

/**
 *
 * @author Amanda
 */
public class HeroZoneView extends JPanel{
    private int length;
    public static final int ENEMY_SPACE_LENGTH = 205;
    
    public HeroZoneView(int x, int y, int numOfHeros, GameConfiguration config){
        length = numOfHeros*ENEMY_SPACE_LENGTH;
        setBounds(config.scale(x), config.scale(y), config.scale(length), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setOpaque(false);
        setLayout(null);
    }
    
    public int getLengthOfHeroZone(){
        return length;
    }

    
}
