//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Amanda
 */
public class CharacterQueryMessageView extends JTextArea{
    
    public CharacterQueryMessageView(int x, int y, String description){
        setBounds(x, y, 500, 500);
        setText(description);
        setBackground(Color.white);
        setLayout(null);
        setOpaque(true);
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
        Font queryFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 36);
        setFont(queryFont);
        setLineWrap(true);
        Border queryBorder = BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK);
        setBorder(queryBorder);
        this.setEditable(false);
    }
}
