//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.phasemanager.GamePhase;
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
    private GameConfiguration config;
    
    public StagingAreaThreatTitleViewController(EncounterZone zone, GameConfiguration config){
        this.encounterArea = zone;
        this.currentPhase = null;
        this.config = config;
    }
    
    public void getCurrentPhase(){
        currentPhase = encounterArea.getCurrentPhase();
    }
    
    public StagingAreaThreatTitleView makeView(int x, int y){
        view = new StagingAreaThreatTitleView(x, y, config);
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
