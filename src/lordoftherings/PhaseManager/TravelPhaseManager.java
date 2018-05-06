//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.PhaseManager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class TravelPhaseManager implements PhaseManager{
    private TravelSubPhase subPhase;
    
    public TravelPhaseManager(){
        subPhase = TravelSubPhase.SELECT_ACTIVE_LOCATION;
    }
    
    public TravelPhaseManager setSubPhase(TravelSubPhase subPhase){
        this.subPhase = subPhase;
        return this;
    }

    @Override
    public void onStartSubPhase(Board board) {
    }

    @Override
    public void onEndSubPhase(Board board) {
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        return board.getEncounterPhaseManager();
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.TRAVEL;
    }

    @Override
    public SubPhase getSubPhase() {
        return subPhase;
    }

    @Override
    public boolean canProgress(Board board) {
        return true;
    }
    
}
