//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Amanda
 */
public class QuestValueView extends JLabel{
    public static final Font QUEST_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 30);
    
    public QuestValueView(int x, int y){
        setBounds(x, y, 200, 50);
        setLayout(null);
        setOpaque(true);
        setText("" + 0);
        setBackground(Color.CYAN);
        
        setFont(QUEST_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
