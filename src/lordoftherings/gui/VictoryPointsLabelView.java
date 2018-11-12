//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.gui.SubPhaseView.SUBPHASE_FONT_SIZE;

/**
 *
 * @author Amanda
 */
public class VictoryPointsLabelView extends JLabel{
    
    public VictoryPointsLabelView(int x, int y, int numOfPoints){
        setBounds(x, y, PhaseView.PHASE_BUTTON_WIDTH, 50);
        setText("Total Victory Points: " + numOfPoints);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.CYAN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        Font phaseFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 25);
        setFont(phaseFont);
    }
}
