//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QueryHeroCardView extends JTextArea{
       
    public QueryHeroCardView(String heroInfo, boolean isTapped, GameConfiguration config){
        this.setRows(11);
        this.setColumns(1);
        this.insert(heroInfo, 0);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.LIGHT_GRAY);
        if(isTapped){
            setBounds(0, config.scale(HandCardView.CARD_HEIGHT - 
                    HandCardView.CARD_WIDTH), 
                    config.scale(HandCardView.CARD_HEIGHT), 
                    config.scale(HandCardView.CARD_WIDTH));
        }else{
            setBounds(0, 0, config.scale(HandCardView.CARD_WIDTH), 
                    config.scale(HandCardView.CARD_HEIGHT));
        }
        
    }
}
