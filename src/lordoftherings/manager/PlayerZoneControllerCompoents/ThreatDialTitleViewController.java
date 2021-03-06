//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Color;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialTitleView;

/**
 *
 * @author Amanda
 */
public class ThreatDialTitleViewController {
    
    private PlayerZone zone;
    private ThreatDialTitleView titleView;
    private GameConfiguration config;
    
    public ThreatDialTitleViewController(PlayerZone zone, GameConfiguration config){
        this.zone = zone;
        this.config = config;
    }
    
    public ThreatDialTitleView makeView(int x, int y){
        titleView = new ThreatDialTitleView(x, y, config);
        titleView.setVisible(true);
        return titleView;
    }
    
    public void updateView(){
        int currentThreat = zone.getCurrentPlayerThreat();
        if(currentThreat >= 40 && currentThreat < 50){
            titleView.setBackground(Color.ORANGE);
        }else if(currentThreat >= 50){
            titleView.setBackground(Color.RED);
        }
    }
    
}
