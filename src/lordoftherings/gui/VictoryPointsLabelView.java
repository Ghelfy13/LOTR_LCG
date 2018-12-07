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
public class VictoryPointsLabelView extends JLabel{
    
    public static final int VPLABEL_HEIGHT = 50;
    
    public VictoryPointsLabelView(int x, int y, int numOfPoints, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(PhaseView.PHASE_BUTTON_WIDTH), 
                config.scale(VPLABEL_HEIGHT));
        setText("Total Victory Points: " + numOfPoints);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.CYAN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getVictoryPointsLabelFont());
    }
}
