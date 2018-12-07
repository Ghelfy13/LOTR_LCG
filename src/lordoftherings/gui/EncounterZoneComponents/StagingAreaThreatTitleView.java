//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
import static lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView.THREAT_HEIGHT;
import static lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView.THREAT_WIDTH;

/**
 *
 * @author Amanda
 */
public class StagingAreaThreatTitleView extends JLabel{
    
    
    public StagingAreaThreatTitleView(int x, int y, GameConfiguration config){
        setText("THREAT");
        setBounds(config.scale(x), config.scale(y), config.scale(THREAT_WIDTH), config.scale(THREAT_HEIGHT));
        setLayout(null);
        setBackground(Color.ORANGE);
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getThreatFont());
    }
    
}
