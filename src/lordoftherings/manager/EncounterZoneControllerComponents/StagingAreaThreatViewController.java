//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.awt.Font;
import lordoftherings.GameConfiguration;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView;
import lordoftherings.boardcomponents.StagingArea;
/**
 *
 * @author Amanda
 */
public class StagingAreaThreatViewController {
    private StagingAreaThreatView threatView;
    private StagingArea stage;
    private EncounterZone zone;
    private GameConfiguration config;
    
    public StagingAreaThreatViewController(EncounterZone zone, GameConfiguration config){
        this.zone = zone;
        this.stage = zone.getStagingArea();
        this.config = config;
    }
    
    public StagingAreaThreatView makeView(int x, int y){
        threatView = new StagingAreaThreatView(x, y, stage.getCurrentThreat(), config);
        threatView.setVisible(false);
        return threatView;
    }
    
    public void updateView(){
        GamePhase currentPhase = zone.getCurrentPhase();
        if(currentPhase == GamePhase.QUEST){
            threatView.setText("" + stage.getCurrentThreat());
            threatView.revalidate();
            threatView.repaint();
            threatView.setVisible(true);
        }else{
            threatView.setVisible(false);
        }
        
    }
    
}
