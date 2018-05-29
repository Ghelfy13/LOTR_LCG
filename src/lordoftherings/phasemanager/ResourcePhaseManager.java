//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class ResourcePhaseManager implements PhaseManager{
    private ResourceSubPhase subPhase;
    private boolean isActionable;
    
    public ResourcePhaseManager(){
        this.subPhase = ResourceSubPhase.ADD_RESOURCES_AND_DRAW;
        isActionable = true;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        if(subPhase == ResourceSubPhase.ADD_RESOURCES_AND_DRAW){
            board.addResourcesToHerosAndDraw();
            isActionable = false;
        }else if(subPhase == ResourceSubPhase.PLAYER_ACTIONS){
            isActionable = true;
        }
    }
    
    public ResourcePhaseManager setSubPhase(ResourceSubPhase phase){
        subPhase = phase;
        return this;
    }

    @Override
    public void onEndSubPhase(Board board) {
        
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        if(subPhase == ResourceSubPhase.ADD_RESOURCES_AND_DRAW){
            return board.getPhaseManagerGovenor().getResourcePhaseManager().
                    setSubPhase(ResourceSubPhase.PLAYER_ACTIONS);
        }else{
            return board.getPhaseManagerGovenor().getPlanningPhaseManager();
        }
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.RESOURCE;
    }

    @Override
    public SubPhase getSubPhase() {
        return subPhase;
    }

    @Override
    public boolean canProgress(Board board) {
        return true;
    }

    @Override
    public boolean isActionable() {
        return isActionable;
    }
    
}
