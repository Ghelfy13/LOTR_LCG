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
public class SubPhaseView extends JLabel{
    public static final int SUBPHASE_WIDTH = 
            ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH + PhaseView.PHASE_BUTTON_WIDTH;
    public static final int SUBPHASE_HEIGHT = 40;
    
    public SubPhaseView(String phase, int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(SUBPHASE_WIDTH),
                config.scale(SUBPHASE_HEIGHT));
        setText(phase);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getSubPhaseFont());
    }
}
