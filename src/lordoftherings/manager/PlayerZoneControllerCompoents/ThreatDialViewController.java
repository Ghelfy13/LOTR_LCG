//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Color;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialView;

/**
 *
 * @author Amanda
 */
public class ThreatDialViewController {
    private ThreatDialView dialView;
    private PlayerZone zone;
    
    ThreatDialViewController(PlayerZone zone){
        this.zone = zone;
    }
    
    public ThreatDialView makeView(int x, int y){
        int threat = zone.getInitialHeroThreat();
        dialView = new ThreatDialView(threat, x, y);
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
