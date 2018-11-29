//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HeroZoneView;

/**
 *
 * @author Amanda
 */
public class QueryHeroAreaView extends JPanel{
    private int length;
    
    public QueryHeroAreaView(int x, int y, int numOfHeros){
        length = numOfHeros*HeroZoneView.ENEMY_SPACE_LENGTH;
        setBounds(scale(x), scale(y), length, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setOpaque(false);
        setLayout(null);
    }
    
    public int getLength(){
        return length;
    }
}
