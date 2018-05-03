//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.PhaseManager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class RefreshPhaseManager implements PhaseManager{
    private RefreshSubPhase subPhase;
    
    public RefreshPhaseManager(){
        subPhase = RefreshSubPhase.REFRESH_CARDS;
    }
    
    public RefreshPhaseManager setSubPhase(RefreshSubPhase phase){
        subPhase = phase;
        return this;
    }    

    @Override
    public void onStartSubPhase(Board board) {
        switch (subPhase){
            case REFRESH_CARDS:
                return;
            case INCREASE_THREAT:
                return;
            case PASS_FIRST_PLAYER_TOKEN:
                return;
        }
        
    }

    @Override
    public void onEndSubPhase(Board board) {
        switch (subPhase){
            case REFRESH_CARDS:
                for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                    board.getPlayerZoneAt(i).readyCharacters();
                }
                return;
            case INCREASE_THREAT:
                board.increaseEveryPlayersThreatBy(1);
                return;
            case PASS_FIRST_PLAYER_TOKEN:
                return;
        }
        
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        switch (subPhase){
            case REFRESH_CARDS:
                return board.getRefreshPhaseManager().setSubPhase(RefreshSubPhase.INCREASE_THREAT);
            case INCREASE_THREAT:
                return board.getRefreshPhaseManager().setSubPhase(RefreshSubPhase.PASS_FIRST_PLAYER_TOKEN);
            case PASS_FIRST_PLAYER_TOKEN:
                return board.getResourcePhaseManager();
            default:
                return null;
        }
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.REFRESH;
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
