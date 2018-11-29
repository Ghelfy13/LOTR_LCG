//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QuestCardView extends JTextArea{
    
    public QuestCardView(String enemyInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(enemyInfo, 0);
        this.setFont(AllyCardView.CARD_FONT);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(x, y, scale(HandCardView.CARD_HEIGHT), scale(HandCardView.CARD_WIDTH));
    }
}
