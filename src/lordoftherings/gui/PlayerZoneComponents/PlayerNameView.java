//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.gui.ProgressPhaseButtonView;

/**
 *
 * @author Amanda
 */
public class PlayerNameView extends JLabel{
    
    public PlayerNameView(int x, int y, String name){
        setBounds(x, y, 
                ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH, 
                ProgressPhaseButtonView.PROGRESS_BUTTON_HEIGHT);
        setText(name);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setFont(QuestValueView.QUEST_FONT);
        setBackground(Color.CYAN);
        setOpaque(true);
    }
}
