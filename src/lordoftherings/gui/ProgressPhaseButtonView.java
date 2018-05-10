//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;

/**
 *
 * @author Amanda
 */
public class ProgressPhaseButtonView extends JButton{
    public static final int PROGRESS_BUTTON_WIDTH = 225;
    public static final int PROGRESS_BUTTON_HEIGHT = 50;
    
    public ProgressPhaseButtonView(int x, int y){
        setBounds(x, y, PROGRESS_BUTTON_WIDTH, PROGRESS_BUTTON_HEIGHT);
        setText("Next Phase >>");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        setFont(QuestValueView.QUEST_FONT);
        setBackground(Color.CYAN);
    }
}
