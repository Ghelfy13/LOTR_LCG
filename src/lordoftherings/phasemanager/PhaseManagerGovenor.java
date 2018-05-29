//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class PhaseManagerGovenor {
    private PhaseManager currentPhaseManager;
    private ResourcePhaseManager resourcePM;
    private PlanningPhaseManager planningPM;
    private GamePhase currentGamePhase;
    private QuestPhaseManager questPM;
    private TravelPhaseManager travelPM;
    private EncounterPhaseManager encounterPM;
    private RefreshPhaseManager refreshPM;
    private CombatPhaseManager combatPM;
    private Board board;
    
    public PhaseManagerGovenor(Board board){
        this.board = board;
        this.currentGamePhase = GamePhase.RESOURCE;
        this.resourcePM = new ResourcePhaseManager();
        this.currentPhaseManager = resourcePM.setSubPhase(ResourceSubPhase.ADD_RESOURCES_AND_DRAW);
        currentPhaseManager.onStartSubPhase(board);
        this.planningPM = new PlanningPhaseManager();
        this.questPM = new QuestPhaseManager();
        this.travelPM = new TravelPhaseManager();
        this.encounterPM = new EncounterPhaseManager();
        this.refreshPM = new RefreshPhaseManager();
        this.combatPM = new CombatPhaseManager();
    }
    
    public SubPhase getCurrentSubPhase(){
        return currentPhaseManager.getSubPhase();
    }
    
     public GamePhase getCurrentPhase(){
        return currentPhaseManager.getPhase();
    }
     
    public boolean isCurrentPhaseActionable(){
        return currentPhaseManager.isActionable();
    }
     
     public boolean canProgressPhase(){
        return currentPhaseManager.canProgress(board);
    }
    
    public void advancePhase(){
        if(!currentPhaseManager.canProgress(board)){
            return;
        }
        currentPhaseManager.onEndSubPhase(board);
        currentPhaseManager = currentPhaseManager.getNextPhase(board);
        currentPhaseManager.onStartSubPhase(board);
    }
    
    public ResourcePhaseManager getResourcePhaseManager(){
        return resourcePM;
    }
    
    public PlanningPhaseManager getPlanningPhaseManager() {
        return planningPM;
    }
    
    public CombatPhaseManager getCombatPhaseManager(){
        return combatPM;
    }
    
    public QuestPhaseManager getQuestPhaseManager() {
        return questPM;
    }
    
    public TravelPhaseManager getTravelPhaseManager(){
        return travelPM;
    }
    
    public EncounterPhaseManager getEncounterPhaseManager(){
        return encounterPM;
    }
    
    public RefreshPhaseManager getRefreshPhaseManager() {
        return refreshPM;
    }
}
