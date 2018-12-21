//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;

/**
 *
 * @author Amanda
 */
public class StagingAreaThreatView extends JLabel{
    public static final int THREAT_WIDTH = 150;
    public static final int THREAT_HEIGHT = 50;
    
    public StagingAreaThreatView(int x, int y, int threat, GameConfiguration config){
        setText("" + threat);
        setBounds(config.scale(x), config.scale(y), 
                config.scale(THREAT_WIDTH), config.scale(THREAT_HEIGHT));
        setLayout(null);
        setBackground(Color.ORANGE);
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getQuestPhaseFont());
    }
    
}
