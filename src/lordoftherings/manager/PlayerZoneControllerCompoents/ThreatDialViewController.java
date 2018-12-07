//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Color;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialView;

/**
 *
 * @author Amanda
 */
public class ThreatDialViewController {
    private ThreatDialView dialView;
    private PlayerZone zone;
    private GameConfiguration config;
    
    ThreatDialViewController(PlayerZone zone, GameConfiguration config){
        this.zone = zone;
        this.config = config;
    }
    
    public ThreatDialView makeView(int x, int y){
        int threat = zone.getInitialHeroThreat();
        dialView = new ThreatDialView(threat, x, y, config);
        dialView.setVisible(true);
        return dialView;
    }
    
    public void updateView(){
        int currentThreat = zone.getCurrentPlayerThreat();
        if(currentThreat >= 40 && currentThreat < 50){
            dialView.setBackground(Color.ORANGE);
        }else if(currentThreat >= 50){
            dialView.setBackground(Color.RED);
        }
        dialView.setText("" + currentThreat);
    }
}
