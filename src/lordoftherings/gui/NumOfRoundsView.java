//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsView extends JLabel{
    public static final int LABEL_HEIGHT = scale(30);
    
    public NumOfRoundsView(int x, int y, int numOfRounds){
        setBounds(scale(x), scale(y), HandCardView.CARD_WIDTH, LABEL_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setText("" + numOfRounds);
        setBackground(Color.ORANGE);
        setFont(QuestValueView.QUEST_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
