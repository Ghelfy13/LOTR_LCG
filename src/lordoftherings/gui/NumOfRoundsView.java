//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsView extends JLabel{
    
    public NumOfRoundsView(int x, int y, int numOfRounds){
        setBounds(x, y, 200, 50);
        setLayout(null);
        setOpaque(true);
        setText("" + numOfRounds);
        setBackground(Color.GREEN);
        setFont(QuestValueView.QUEST_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
