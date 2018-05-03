//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class StagingAreaView extends JPanel{
    public static final int STAGING_AREA_WIDTH = 270 * 5;
    public static final int STAGING_AREA_HEIGHT = 300;
    
    public StagingAreaView(int x, int y, MouseMotionListener mmListener){
        setBounds(x, y, STAGING_AREA_WIDTH, STAGING_AREA_HEIGHT);
        setLayout(null);
        setOpaque(true);
        setBackground(Color.WHITE);
        this.addMouseMotionListener(mmListener);
    }
}
