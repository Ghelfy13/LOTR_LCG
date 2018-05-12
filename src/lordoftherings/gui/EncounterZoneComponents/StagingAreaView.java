//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;

/**
 *
 * @author Amanda
 */
public class StagingAreaView extends JPanel{
        
    public StagingAreaView(int x, int y, MouseMotionListener mmListener){
        setBounds(x, y, EngagementAreaView.AREA_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(false);
        //setBackground(Color.WHITE);
        this.addMouseMotionListener(mmListener);
    }
}
