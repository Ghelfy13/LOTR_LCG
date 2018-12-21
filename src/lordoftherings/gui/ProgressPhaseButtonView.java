//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class ProgressPhaseButtonView extends JButton{
    public static final int PROGRESS_BUTTON_WIDTH = 225;
    public static final int PROGRESS_BUTTON_HEIGHT = 50;
    
    public ProgressPhaseButtonView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(PROGRESS_BUTTON_WIDTH), 
                config.scale(PROGRESS_BUTTON_HEIGHT));
        setText("Next Phase >>");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        setFont(config.getFonts().getQuestPhaseFont());
        setBackground(Color.CYAN);
    }
    
}
