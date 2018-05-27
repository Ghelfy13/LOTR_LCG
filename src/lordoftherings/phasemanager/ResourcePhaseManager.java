//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class ResourcePhaseManager implements PhaseManager{
    private ResourceSubPhase subPhase;
    
    public ResourcePhaseManager(){
        this.subPhase = ResourceSubPhase.ADD_RESOURCES_AND_DRAW;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        if(subPhase == ResourceSubPhase.ADD_RESOURCES_AND_DRAW){
            board.addResourcesToHerosAndDraw();
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
        return board.getPhaseManagerGovenor().getPlanningPhaseManager();
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
        //TODO
    }
    
}
