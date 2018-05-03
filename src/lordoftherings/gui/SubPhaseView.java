//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Amanda
 */
public class SubPhaseView extends JLabel{
    public static final int SUBPHASE_FONT_SIZE = 20;
    
    public SubPhaseView(String phase, int x, int y){
        setBounds(x, y, ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH + PhaseView.PHASE_BUTTON_WIDTH, 40);
        setText(phase);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        Font phaseFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, SUBPHASE_FONT_SIZE);
        setFont(phaseFont);
    }
}
