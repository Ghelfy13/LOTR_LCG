//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class PhaseView extends JLabel {
    public static final int PHASE_BUTTON_WIDTH = scale(250);
    public static final int PHASE_BUTTON_HEIGHT = scale(50);
    public static final int PHASE_FONT_SIZE = scale(30);
    
    public PhaseView(String title, int x, int y){
        setBounds(scale(x), scale(y), PHASE_BUTTON_WIDTH, PHASE_BUTTON_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setText(title);
        setBackground(Color.ORANGE);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        Font phaseFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, PHASE_FONT_SIZE);
        setFont(phaseFont);
    }
}
