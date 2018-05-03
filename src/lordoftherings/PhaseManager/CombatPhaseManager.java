//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.PhaseManager;

import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.EngagedEnemyArea;

/**
 *
 * @author Amanda
 */
public class CombatPhaseManager implements PhaseManager{
    private CombatSubPhase subPhase;
    
    public CombatPhaseManager(){
        subPhase = CombatSubPhase.RESOLVE_ENEMY_ATTACKS;
    }
    
    public CombatPhaseManager setSubPhase(CombatSubPhase subPhase){
        this.subPhase = subPhase;
        return this;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
            if(subPhase == CombatSubPhase.RESOLVE_ENEMY_ATTACKS){
                board.getPlayerZoneAt(i).getEngagementArea().setEnemiesToAttacking();
            }else if(subPhase == CombatSubPhase.RESOLVE_PLAYER_ATTACKS){
                board.getPlayerZoneAt(i).getEngagementArea().setEnemiesToDefending();
            }
        }
    }

    @Override
    public void onEndSubPhase(Board board) {
        if(subPhase == CombatSubPhase.RESOLVE_PLAYER_ATTACKS){
            for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                board.getPlayerZoneAt(i).setEnemiesToAttackedAndDefended();
            }
        }
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        if(canProgress(board)){
            if(subPhase == CombatSubPhase.RESOLVE_ENEMY_ATTACKS){
                return board.getCombatPhaseManager().setSubPhase(CombatSubPhase.RESOLVE_PLAYER_ATTACKS);
            }else{
                return board.getRefreshPhaseManager().setSubPhase(RefreshSubPhase.REFRESH_CARDS);
            }
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.COMBAT;
    }

    @Override
    public SubPhase getSubPhase() {
        return subPhase;
    }

    @Override
    public boolean canProgress(Board board) {
        EngagedEnemyArea area = board.getPlayerZoneAt(board.getCurrentPlayerNum()).getEngagementArea();
        if(subPhase == CombatSubPhase.RESOLVE_ENEMY_ATTACKS){
            return !area.enemiesStillAttacking();
        }else {
            return true;
        }
    }
    
}
