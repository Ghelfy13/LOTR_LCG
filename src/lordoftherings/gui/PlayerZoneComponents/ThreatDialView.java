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
public class ThreatDialView extends JLabel{
    
    public ThreatDialView(int initialThreat, int x, int y){
        setBounds(x, y, 200, 50);
        setLayout(null);
        setOpaque(true);
        setText("" + initialThreat);
        setBackground(Color.GREEN);
        Font threatFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 30);
        setFont(threatFont);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
