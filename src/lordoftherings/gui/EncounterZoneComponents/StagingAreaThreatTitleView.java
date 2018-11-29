//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;
import static lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView.THREAT_HEIGHT;
import static lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView.THREAT_WIDTH;

/**
 *
 * @author Amanda
 */
public class StagingAreaThreatTitleView extends JLabel{
    public static final Font THREAT_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 24);
    
    public StagingAreaThreatTitleView(int x, int y){
        setText("THREAT");
        setBounds(x, y, scale(THREAT_WIDTH), scale(THREAT_HEIGHT));
        setLayout(null);
        setBackground(Color.ORANGE);
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(THREAT_FONT);
    }
}
