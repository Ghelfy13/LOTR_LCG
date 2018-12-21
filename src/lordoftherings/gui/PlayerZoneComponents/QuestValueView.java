//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
/**
 *
 * @author Amanda
 */
public class QuestValueView extends JLabel{
    
    public static final int QUEST_WIDTH = 200;
    public static final int QUEST_HEIGHT = 50;
    
    public QuestValueView(int x, int y, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(QUEST_WIDTH), config.scale(QUEST_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setText("" + 0);
        setBackground(Color.CYAN);
        setFont(config.getFonts().getQuestPhaseFont());
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    
}
