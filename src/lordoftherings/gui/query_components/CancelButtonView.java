//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;

/**
 *
 * @author Amanda
 */
public class CancelButtonView extends JButton{
    
    public CancelButtonView(int x, int y, boolean canCancel){
        setBounds(x, y, 200, 50);
        setText("Cancel");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        setFont(QuestValueView.QUEST_FONT);
        if(canCancel){
            setBackground(Color.LIGHT_GRAY);
        }
        else{
            setBackground(Color.darkGray);
        }
    }

    public void updateView(boolean canCancel) {
        if(canCancel){
            setBackground(Color.LIGHT_GRAY);
        }
        else{
            setBackground(Color.darkGray);
        }
        revalidate();
        repaint();
    }
}
