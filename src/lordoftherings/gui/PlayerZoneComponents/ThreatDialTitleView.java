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
public class ThreatDialTitleView extends JLabel{
    
    public ThreatDialTitleView(int x, int y){
        setText("THREAT DIAL");
        setBounds(scale(x), scale(y), QuestValueView.QUEST_WIDTH, QuestValueView.QUEST_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(StagingAreaThreatTitleView.THREAT_FONT);
    }
}
