//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;

/**
 *
 * @author Amanda
 */
public class ContinueButtonView extends JButton {
    
    public ContinueButtonView(int x, int y, boolean canContinue){
        setBounds(x, y, 200, 50);
        setText("Continue");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        setFont(QuestValueView.QUEST_FONT);
        if(canContinue){
           setBackground(Color.LIGHT_GRAY); 
        }
        else{
            setBackground(Color.darkGray);
        }
    }
    
    public void updateView(boolean canContinue){
        if(canContinue){
            setBackground(Color.LIGHT_GRAY);
        }else{
            setBackground(Color.darkGray);
        }
        revalidate();
        repaint();
    }
}
