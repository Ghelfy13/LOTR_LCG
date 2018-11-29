//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;
import static lordoftherings.gui.SubPhaseView.SUBPHASE_FONT_SIZE;

/**
 *
 * @author Amanda
 */
public class VictoryPointsLabelView extends JLabel{
    public static final Font PHASE_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, scale(25));
    public static final int VPLABEL_HEIGHT = scale(50);
    
    public VictoryPointsLabelView(int x, int y, int numOfPoints){
        setBounds(scale(x), scale(y), PhaseView.PHASE_BUTTON_WIDTH, VPLABEL_HEIGHT);
        setText("Total Victory Points: " + numOfPoints);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.CYAN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(PHASE_FONT);
    }
}
