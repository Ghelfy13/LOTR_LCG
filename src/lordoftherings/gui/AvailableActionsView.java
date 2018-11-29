//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class AvailableActionsView extends JLabel {
    public static final Font MESSAGE_FONT = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, scale(36));
    int lengthOfBox;
    public static final int USED_BOX_LENGTH = scale(ActionView.BOX_DIMENSIONS + 10);
    
    public AvailableActionsView(int x, int y, int numOfActions){
        if(numOfActions == 0){
            lengthOfBox = ActionView.BOX_DIMENSIONS;
        }else{
            lengthOfBox = USED_BOX_LENGTH*numOfActions;
        }
        setBounds(scale(x), scale(y), lengthOfBox, USED_BOX_LENGTH);//width of card = 180, need to change that to fit the number of buttons needed
        //button separation will be 10 - 40 - 10 again, where the button is 40 in width
        setBackground(Color.ORANGE);
        setFont(MESSAGE_FONT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
        setLayout(null);
    }
}