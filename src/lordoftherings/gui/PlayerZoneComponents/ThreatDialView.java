//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class ThreatDialView extends JLabel{
    
    public ThreatDialView(int initialThreat, int x, int y){
        setBounds(scale(x), scale(y), QuestValueView.QUEST_WIDTH, QuestValueView.QUEST_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setText("" + initialThreat);
        setBackground(Color.GREEN);
        setFont(QuestValueView.QUEST_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
