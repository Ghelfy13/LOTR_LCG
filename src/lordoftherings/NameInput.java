//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class NameInput {
    private JFrame frame;
    private String playerName;
    
    public NameInput(){
        frame = new JFrame();
        playerName = JOptionPane.showInputDialog(frame, "Enter Player Name");
    }
    
    public String getPlayerName(){
        return playerName;
    }
}
