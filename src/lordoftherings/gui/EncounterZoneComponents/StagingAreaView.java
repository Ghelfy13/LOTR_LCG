//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;

/**
 *
 * @author Amanda
 */
public class StagingAreaView extends JPanel{
        
    public StagingAreaView(int x, int y, MouseMotionListener mmListener, GameConfiguration config){
        setBounds(config.scale(x), config.scale(y), config.scale(EngagementAreaView.AREA_WIDTH), config.scale(ActiveLocationView.CARD_COUNTER_HEIGHT));
        setLayout(null);
        setOpaque(false);
        this.addMouseMotionListener(mmListener);
    }
}
