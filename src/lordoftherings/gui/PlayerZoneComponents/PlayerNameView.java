//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
import static lordoftherings.gui.ProgressPhaseButtonView.PROGRESS_BUTTON_HEIGHT;
import static lordoftherings.gui.ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH;

/**
 *
 * @author Amanda
 */
public class PlayerNameView extends JLabel{
    
    public PlayerNameView(int x, int y, String name, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(PROGRESS_BUTTON_WIDTH), 
                config.scale(PROGRESS_BUTTON_HEIGHT));
        setText(name);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setFont(config.getFonts().getQuestPhaseFont());
        setBackground(Color.CYAN);
        setOpaque(true);
    }
}
