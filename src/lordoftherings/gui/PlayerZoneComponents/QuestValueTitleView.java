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
public class QuestValueTitleView extends JLabel{
    
    public QuestValueTitleView(int x, int y){
        setBounds(x, y, 200, 50);
        setLayout(null);
        setOpaque(true);
        setText("QUEST VALUE");
        setBackground(Color.CYAN);
        Font threatFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 25);
        setFont(threatFont);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
