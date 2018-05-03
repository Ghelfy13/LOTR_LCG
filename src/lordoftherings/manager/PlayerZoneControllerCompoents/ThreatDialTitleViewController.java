//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Color;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialTitleView;

/**
 *
 * @author Amanda
 */
public class ThreatDialTitleViewController {
    
    private PlayerZone zone;
    private ThreatDialTitleView titleView;
    
    public ThreatDialTitleViewController(PlayerZone zone){
        this.zone = zone;
    }
    
    public ThreatDialTitleView makeView(int x, int y){
        titleView = new ThreatDialTitleView(x, y);
        titleView.setVisible(true);
        return titleView;
    }
    
    public void updateView(){
        int currentThreat = zone.getCurrentThreat();
        if(currentThreat >= 40 && currentThreat < 50){
            titleView.setBackground(Color.ORANGE);
        }else if(currentThreat >= 50){
            titleView.setBackground(Color.RED);
        }
    }
    
}
