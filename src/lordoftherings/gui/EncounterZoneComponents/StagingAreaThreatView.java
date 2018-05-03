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
public class StagingAreaThreatView extends JLabel{
    
    public StagingAreaThreatView(int x, int y, int threat){
        setText("" + threat);
        setBounds(x, y, 150, 50);
        setLayout(null);
        setBackground(Color.ORANGE);
        setOpaque(true);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        Font threatFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 30);
        setFont(threatFont);
    }
    
}
