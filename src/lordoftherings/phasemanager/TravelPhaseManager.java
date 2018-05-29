//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class TravelPhaseManager implements PhaseManager{
    private TravelSubPhase subPhase;
    private boolean isActionable;
    
    public TravelPhaseManager(){
        subPhase = TravelSubPhase.SELECT_ACTIVE_LOCATION;
        isActionable = false;
    }
    
    public TravelPhaseManager setSubPhase(TravelSubPhase subPhase){
        this.subPhase = subPhase;
        return this;
    }

    @Override
    public void onStartSubPhase(Board board) {
        if(subPhase == TravelSubPhase.SELECT_ACTIVE_LOCATION){
            isActionable = false;
        }else if(subPhase == TravelSubPhase.PLAYER_ACTIONS){
            isActionable = true;
        }
    }

    @Override
    public void onEndSubPhase(Board board) {
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        if(subPhase == TravelSubPhase.SELECT_ACTIVE_LOCATION){
            return board.getPhaseManagerGovenor().getTravelPhaseManager().
                    setSubPhase(TravelSubPhase.PLAYER_ACTIONS);
        }
        return board.getPhaseManagerGovenor().getEncounterPhaseManager().
                setSubPhase(EncounterSubPhase.ENGAGE_ENEMY);
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

    @Override
    public boolean isActionable() {
        return isActionable;
    }
    
}
