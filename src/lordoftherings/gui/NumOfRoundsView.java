//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsView extends JLabel{
    public static final int LABEL_HEIGHT = 30;
    
    public NumOfRoundsView(int x, int y, int numOfRounds, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(LABEL_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setText("" + numOfRounds);
        setBackground(Color.ORANGE);
        setFont(config.getFonts().getQuestValueFont());
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    
   
}
