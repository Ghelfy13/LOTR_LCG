//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.EngagedEnemyArea;

/**
 *
 * @author Amanda
 */
public class CombatPhaseManager implements PhaseManager{
    private CombatSubPhase subPhase;
    private boolean isActionable;
    
    public CombatPhaseManager(){
        subPhase = CombatSubPhase.PREPARATION_ACTIONS;
        isActionable = true;
    }
    
    public CombatPhaseManager setSubPhase(CombatSubPhase subPhase){
        this.subPhase = subPhase;
        return this;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        if(subPhase == CombatSubPhase.PREPARATION_ACTIONS || 
                subPhase == CombatSubPhase.PLAYER_ACTIONS){
            isActionable = true;
        }else if(subPhase != CombatSubPhase.PLAYER_ACTIONS){
            isActionable = false;
            for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                if(subPhase == CombatSubPhase.RESOLVE_ENEMY_ATTACKS){
                    board.getPlayerZoneAt(i).getEngagementArea().setEnemiesToAttacking();
                }else if(subPhase == CombatSubPhase.RESOLVE_PLAYER_ATTACKS){
                    board.getPlayerZoneAt(i).getEngagementArea().setEnemiesToDefending();
                }
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
            switch (subPhase) {
                case PREPARATION_ACTIONS:
                    return board.getPhaseManagerGovenor().getCombatPhaseManager().
                            setSubPhase(CombatSubPhase.RESOLVE_ENEMY_ATTACKS);
                case RESOLVE_ENEMY_ATTACKS:
                    return board.getPhaseManagerGovenor().getCombatPhaseManager().
                            setSubPhase(CombatSubPhase.RESOLVE_PLAYER_ATTACKS);
                case RESOLVE_PLAYER_ATTACKS:
                    return board.getPhaseManagerGovenor().getCombatPhaseManager().
                            setSubPhase(CombatSubPhase.PLAYER_ACTIONS);
                case PLAYER_ACTIONS:
                    return board.getPhaseManagerGovenor().getRefreshPhaseManager().
                            setSubPhase(RefreshSubPhase.REFRESH_CARDS);
                default:
                    break;
            }
        }
        return this;
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

    @Override
    public boolean isActionable() {
        return isActionable;
    }
    
}
