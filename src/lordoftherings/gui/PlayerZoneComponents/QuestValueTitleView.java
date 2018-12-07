//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;

/**
 *
 * @author Amanda
 */
public class QuestValueTitleView extends JLabel{
    
    public QuestValueTitleView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(QuestValueView.QUEST_WIDTH), config.scale(QuestValueView.QUEST_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setText("QUEST VALUE");
        setBackground(Color.CYAN);
        setFont(config.getFonts().getThreatFont());
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
