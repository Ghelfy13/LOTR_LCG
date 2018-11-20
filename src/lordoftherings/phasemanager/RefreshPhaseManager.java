//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class RefreshPhaseManager implements PhaseManager{
    private RefreshSubPhase subPhase;
    private boolean isActionable;
    
    public RefreshPhaseManager(){
        subPhase = RefreshSubPhase.REFRESH_CARDS;
        isActionable = false;
    }
    
    public RefreshPhaseManager setSubPhase(RefreshSubPhase phase){
        subPhase = phase;
        return this;
    }    

    @Override
    public void onStartSubPhase(Board board) {
        switch (subPhase){
            case REFRESH_CARDS:
            case INCREASE_THREAT:
            case PASS_FIRST_PLAYER_TOKEN:
            case RAISE_ROUND_COUNTER:
            case PLAYER_ACTIONS:
                isActionable = true;
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
            case RAISE_ROUND_COUNTER:
                board.getNumOfRounds().raiseRoundCounter();
                return;
            case PLAYER_ACTIONS:
                return;
        }
        
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        switch (subPhase){
            case REFRESH_CARDS:
                return board.getPhaseManagerGovenor().getRefreshPhaseManager().
                        setSubPhase(RefreshSubPhase.INCREASE_THREAT);
            case INCREASE_THREAT:
                return board.getPhaseManagerGovenor().getRefreshPhaseManager().
                        setSubPhase(RefreshSubPhase.PASS_FIRST_PLAYER_TOKEN);
            case PASS_FIRST_PLAYER_TOKEN:
                return board.getPhaseManagerGovenor().getRefreshPhaseManager().
                        setSubPhase(RefreshSubPhase.RAISE_ROUND_COUNTER);
            case RAISE_ROUND_COUNTER:
                return board.getPhaseManagerGovenor().getRefreshPhaseManager().
                        setSubPhase(RefreshSubPhase.PLAYER_ACTIONS);
            case PLAYER_ACTIONS:
                return board.getPhaseManagerGovenor().getResourcePhaseManager().
                        setSubPhase(ResourceSubPhase.ADD_RESOURCES_AND_DRAW);
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

    @Override
    public boolean isActionable() {
        return isActionable;
    }
    
}
