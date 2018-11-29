//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import static lordoftherings.GameConfiguration.scale;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;

/**
 *
 * @author Amanda
 */
public class StagingAreaView extends JPanel{
        
    public StagingAreaView(int x, int y, MouseMotionListener mmListener){
        setBounds(scale(x), scale(y), EngagementAreaView.AREA_WIDTH, ActiveLocationView.CARD_COUNTER_HEIGHT);
        setLayout(null);
        setOpaque(false);
        this.addMouseMotionListener(mmListener);
    }
}
