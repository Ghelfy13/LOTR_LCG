//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsLabelView extends JLabel{
    
    public NumOfRoundsLabelView(int x, int y, GameConfiguration config){
        setText("ROUNDS");
        setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(NumOfRoundsView.LABEL_HEIGHT));
        setLayout(null);
        setOpaque(true);
        setBackground(Color.ORANGE);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(config.getFonts().getThreatFont());
    }
}
