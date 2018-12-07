//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.AvailableActionsView;

/**
 *
 * @author Amanda
 */
public class QueryMessageView extends JTextArea{
    public static final int MESSAGE_DIMENSIONS = 500;
    
    public QueryMessageView(int x, int y, String description, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(MESSAGE_DIMENSIONS), 
                config.scale(MESSAGE_DIMENSIONS));
        setText(description);
        setBackground(Color.white);
        setLayout(null);
        setOpaque(true);
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
        setFont(config.getFonts().getMessageFont());
        setLineWrap(true);
        setWrapStyleWord(true);
        Border queryBorder = BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK);
        setBorder(queryBorder);
        this.setEditable(false);
    }
}
