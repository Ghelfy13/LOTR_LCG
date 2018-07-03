//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import lordoftherings.gui.AvailableActionsView;

/**
 *
 * @author Amanda
 */
public class QueryMessageView extends JTextArea{
    
    public QueryMessageView(int x, int y, String description){
        setBounds(x, y, 500, 500);
        setText(description);
        setBackground(Color.white);
        setLayout(null);
        setOpaque(true);
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
        setFont(AvailableActionsView.MESSAGE_FONT);
        setLineWrap(true);
        Border queryBorder = BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK);
        setBorder(queryBorder);
        this.setEditable(false);
    }
}
