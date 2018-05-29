//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Amanda
 */
public class AvailableActionsView extends JLabel {
    //TODO: MAKE A JLABEL WITH IMAGE ICON BUTTONS TO PERFORM AN ACTION
    public static final Font MESSAGE_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 36);
    
    public AvailableActionsView(int x, int y, int numOfActions){
        int lengthOfBox = ActionView.BOX_DIMENSIONS*2*numOfActions;
        setBounds(x, y, lengthOfBox, ActionView.BOX_DIMENSIONS*2);//width of card = 180, need to change that to fit the number of buttons needed
        //button separation will be 10 - 40 - 10 again, where the button is 40 in width
        setBackground(Color.ORANGE);
        setFont(MESSAGE_FONT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
        setLayout(null);
    }
}