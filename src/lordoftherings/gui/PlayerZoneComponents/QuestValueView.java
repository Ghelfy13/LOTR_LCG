//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;
/**
 *
 * @author Amanda
 */
public class QuestValueView extends JLabel{
    public static final Font QUEST_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, scale(20));
    public static final int QUEST_WIDTH = scale(200);
    public static final int QUEST_HEIGHT = scale(50);
    
    public QuestValueView(int x, int y){
        setBounds(scale(x), scale(y), QUEST_WIDTH, QUEST_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setText("" + 0);
        setBackground(Color.CYAN);
        
        setFont(QUEST_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
