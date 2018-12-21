//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;
import static lordoftherings.gui.PlayerZoneComponents.QuestValueView.QUEST_HEIGHT;
import static lordoftherings.gui.PlayerZoneComponents.QuestValueView.QUEST_WIDTH;

/**
 *
 * @author Amanda
 */
public class ContinueButtonView extends JButton {
    
    public ContinueButtonView(int x, int y, boolean canContinue, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(QUEST_WIDTH), 
                config.scale(QUEST_HEIGHT));
        setText("Continue");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        setFont(config.getFonts().getQuestPhaseFont());
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
