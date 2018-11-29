//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;

/**
 *
 * @author Amanda
 */
public class QuestValueTitleView extends JLabel{
    
    public QuestValueTitleView(int x, int y){
        setBounds(scale(x), scale(y), QuestValueView.QUEST_WIDTH, QuestValueView.QUEST_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setText("QUEST VALUE");
        setBackground(Color.CYAN);
        setFont(StagingAreaThreatTitleView.THREAT_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
