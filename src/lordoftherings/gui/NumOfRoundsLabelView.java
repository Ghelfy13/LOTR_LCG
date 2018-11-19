//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsLabelView extends JLabel{
    
    public NumOfRoundsLabelView(int x, int y){
        setText("ROUNDS");
        setBounds(x, y, 200, 50);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(StagingAreaThreatTitleView.THREAT_FONT);
    }
}
