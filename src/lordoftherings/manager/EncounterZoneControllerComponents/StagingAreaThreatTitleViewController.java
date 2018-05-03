//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;

/**
 *
 * @author Amanda
 */
public class StagingAreaThreatTitleViewController {
    private StagingAreaThreatTitleView view;
    private EncounterZone encounterArea;
    private GamePhase currentPhase;
    
    public StagingAreaThreatTitleViewController(EncounterZone zone){
        this.encounterArea = zone;
        this.currentPhase = null;
    }
    
    public void getCurrentPhase(){
        currentPhase = encounterArea.getCurrentPhase();
    }
    
    public StagingAreaThreatTitleView makeView(int x, int y){
        view = new StagingAreaThreatTitleView(x, y);
        view.setVisible(false);
        return view;
    }
    
   public void updateView(){
        GamePhase currentPhase = encounterArea.getCurrentPhase();
        if(currentPhase == GamePhase.QUEST){
            view.revalidate();
            view.repaint();
            view.setVisible(true);
        }else{
            view.setVisible(false);
        }
        
    }
}
