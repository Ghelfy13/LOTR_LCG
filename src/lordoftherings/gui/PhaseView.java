//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class PhaseView extends JLabel {
    public static final int PHASE_BUTTON_WIDTH = 250;
    public static final int PHASE_BUTTON_HEIGHT = 50;
    
    public PhaseView(String title, int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(PHASE_BUTTON_WIDTH),
                config.scale(PHASE_BUTTON_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setText(title);
        setBackground(Color.ORANGE);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getPhaseFont());
    }
}
