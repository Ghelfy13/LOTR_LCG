//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsLabelView extends JLabel{
    
    public NumOfRoundsLabelView(int x, int y){
        setText("ROUNDS");
        setBounds(x, y, HandCardView.CARD_WIDTH, NumOfRoundsView.LABEL_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.ORANGE);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(StagingAreaThreatTitleView.THREAT_FONT);
    }
}
