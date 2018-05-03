//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Amanda
 */
public class AvailableActionsView extends JLabel {
    //TODO: MAKE A JLABEL WITH IMAGE ICON BUTTONS TO PERFORM AN ACTION
    
    public AvailableActionsView(int x, int y){
        setBounds(x, y, 100, 100);//width of card = 180, need to change that to fit the number of buttons needed
        //button separation will be 10 - 40 - 10 again, where the button is 40 in width
        setBackground(Color.LIGHT_GRAY);
        Font actionPanelFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 36);
        setFont(actionPanelFont);
        setOpaque(true);
        setLayout(null);
    }
}