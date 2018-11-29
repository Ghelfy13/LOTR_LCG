//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;
import lordoftherings.gui.ProgressPhaseButtonView;

/**
 *
 * @author Amanda
 */
public class QueryPlayerNameView extends JLabel{
    
     public QueryPlayerNameView(int x, int y, String name){
        setBounds(scale(x), scale(y), 
                ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH, 
                ProgressPhaseButtonView.PROGRESS_BUTTON_HEIGHT);
        setText(name);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setFont(QuestValueView.QUEST_FONT);
        setBackground(Color.CYAN);
        setOpaque(true);
    }
}
