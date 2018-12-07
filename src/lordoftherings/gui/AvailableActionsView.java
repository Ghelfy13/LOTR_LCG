//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class AvailableActionsView extends JLabel {
    public int lengthOfBox;
    public static final int USED_BOX_LENGTH = 50;
    
    public AvailableActionsView(int x, int y, int numOfActions, GameConfiguration config){
        if(numOfActions == 0){
            lengthOfBox = ActionView.BOX_DIMENSIONS;
        }else{
            lengthOfBox = USED_BOX_LENGTH*numOfActions;
        }
        setBounds(config.scale(x), config.scale(y), config.scale(lengthOfBox), 
                config.scale(USED_BOX_LENGTH));//width of card = 180, need to change that to fit the number of buttons needed
        //button separation will be 10 - 40 - 10 again, where the button is 40 in width
        setBackground(Color.ORANGE);
        setFont(config.getFonts().getMessageFont());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
        setLayout(null);
    }
}