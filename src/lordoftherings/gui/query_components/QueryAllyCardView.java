//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QueryAllyCardView extends JTextArea {
    
    public QueryAllyCardView(String allyInfo, boolean isTapped, GameConfiguration config){
        if(isTapped){
            setBounds(0, config.scale(HandCardView.CARD_HEIGHT - HandCardView.CARD_WIDTH), 
                    config.scale(HandCardView.CARD_HEIGHT), 
                    config.scale(HandCardView.CARD_WIDTH));
        }else{
            setBounds(0, 0, config.scale(HandCardView.CARD_WIDTH), 
                    config.scale(HandCardView.CARD_HEIGHT));
        }
        this.setEditable(false);
        this.insert(allyInfo,0);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(config.getFonts().getCardFont());
        this.setBackground(Color.LIGHT_GRAY);
        
    }
}
