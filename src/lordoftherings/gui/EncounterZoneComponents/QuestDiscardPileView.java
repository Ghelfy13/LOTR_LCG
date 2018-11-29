//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView.CARD_BORDER;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QuestDiscardPileView extends JPanel{
    public static final Color BACKGROUND = new Color(164, 117, 170);
    
    public QuestDiscardPileView(int x, int y){
        setBounds(scale(x), scale(y), HandCardView.CARD_HEIGHT + CARD_BORDER, 
                HandCardView.CARD_WIDTH + CARD_BORDER);
        setLayout(null);
        setOpaque(true);
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public QuestDiscardPileView getView(){
        return this;
    }
}
