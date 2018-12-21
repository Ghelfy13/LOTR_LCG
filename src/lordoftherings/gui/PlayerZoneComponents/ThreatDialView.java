//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class ThreatDialView extends JLabel{
    
    public ThreatDialView(int initialThreat, int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(QuestValueView.QUEST_WIDTH), config.scale(QuestValueView.QUEST_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setText("" + initialThreat);
        setBackground(Color.GREEN);
        setFont(config.getFonts().getQuestPhaseFont());
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    
}
