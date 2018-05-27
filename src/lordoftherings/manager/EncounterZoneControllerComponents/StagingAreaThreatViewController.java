//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

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
    
    public StagingAreaThreatViewController(EncounterZone zone){
        this.zone = zone;
        this.stage = zone.getStagingArea();
    }
    
    public StagingAreaThreatView makeView(int x, int y){
        threatView = new StagingAreaThreatView(x, y, stage.getCurrentThreat());
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
