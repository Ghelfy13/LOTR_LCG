//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView.CARD_BORDER;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QuestDiscardPileView extends JPanel{
    
    public QuestDiscardPileView(int x, int y){
        setBounds(x, y, HandCardView.CARD_HEIGHT + CARD_BORDER, 
                HandCardView.CARD_WIDTH + CARD_BORDER);
        setLayout(null);
        setOpaque(true);
        Color background = new Color(164, 117, 170);
        setBackground(background);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public QuestDiscardPileView getView(){
        return this;
    }
}
