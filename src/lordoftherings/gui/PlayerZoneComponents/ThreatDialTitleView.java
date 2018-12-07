//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class ThreatDialTitleView extends JLabel{
    
    public ThreatDialTitleView(int x, int y, GameConfiguration config){
        setText("THREAT DIAL");
        setBounds(config.scale(x), config.scale(y), 
                config.scale(QuestValueView.QUEST_WIDTH), 
                config.scale(QuestValueView.QUEST_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getThreatFont());
    }
}
