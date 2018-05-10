//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Amanda
 */
public class StagingAreaThreatTitleView extends JLabel{
    public static final Font THREAT_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 24);
    
    public StagingAreaThreatTitleView(int x, int y){
        setText("THREAT");
        setBounds(x, y, 150, 50);
        setLayout(null);
        setBackground(Color.ORANGE);
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(THREAT_FONT);
    }
}
