//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HeroZoneView;

/**
 *
 * @author Amanda
 */
public class QueryHeroAreaView extends JPanel{
    private int length;
    
    public QueryHeroAreaView(int x, int y, int numOfHeros, GameConfiguration config){
        length = numOfHeros*HeroZoneView.ENEMY_SPACE_LENGTH;
        setBounds(config.scale(x), config.scale(y), config.scale(length), 
                config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setOpaque(false);
        setLayout(null);
    }
    
    public int getLength(){
        return length;
    }
}
