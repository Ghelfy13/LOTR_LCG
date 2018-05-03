//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Amanda
 */
public class ThreatDialTitleView extends JLabel{
    
    public ThreatDialTitleView(int x, int y){
        setText("THREAT DIAL");
        setBounds(x, y, 200, 50);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        Font threatFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 25);
        setFont(threatFont);
    }
}
