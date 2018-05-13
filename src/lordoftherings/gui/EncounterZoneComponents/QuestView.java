//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class QuestView extends JPanel{
    
    public QuestView(int x, int y){
        setBounds(x, y, HandCardView.CARD_HEIGHT, ActiveLocationView.PARENT_WIDTH + 5);
        setLayout(null);
        setOpaque(true);
        
    }
}
