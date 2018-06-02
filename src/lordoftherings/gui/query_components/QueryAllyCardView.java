//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QueryAllyCardView extends JTextArea {
    
    public QueryAllyCardView(String allyInfo, boolean isTapped){
        if(isTapped){
            setBounds(0, HandCardView.CARD_HEIGHT - HandCardView.CARD_WIDTH, 
                    HandCardView.CARD_HEIGHT, HandCardView.CARD_WIDTH);
        }else{
            setBounds(0, 0, HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
        }
        this.setEditable(false);
        this.insert(allyInfo,0);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(AllyCardView.CARD_FONT);
        this.setBackground(Color.LIGHT_GRAY);
        
    }
}
