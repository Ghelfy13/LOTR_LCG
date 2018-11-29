//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class StagingAreaThreatView extends JLabel{
    public static final int THREAT_WIDTH = scale(150);
    public static final int THREAT_HEIGHT = scale(50);
    
    public StagingAreaThreatView(int x, int y, int threat){
        setText("" + threat);
        setBounds(scale(x), scale(y), THREAT_WIDTH, THREAT_HEIGHT);
        setLayout(null);
        setBackground(Color.ORANGE);
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(QuestValueView.QUEST_FONT);
    }
    
}
