//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class EncounterPhaseManager implements PhaseManager{
    private EncounterSubPhase subPhase;
    private boolean isActionable;
    
    public EncounterPhaseManager(){
        subPhase = EncounterSubPhase.ENGAGE_ENEMY;
        isActionable = false;
    }

    @Override
    public void onStartSubPhase(Board board) {
        if(null != subPhase)switch (subPhase) {
            case ENGAGE_ENEMY:
                isActionable = false;
                int numOfPlayerZones = board.getNumOfPlayerZones();
                for(int i = 0; i < numOfPlayerZones; ++i){
                    board.getPlayerZoneAt(i).setEngagedEnemyYet(false);
                }   break;
            case PLAYER_ACTIONS:
            case PREPARATION_ACTIONS:
                isActionable = true;
                break;
            default:
                isActionable = false;
                break;
        }
    }

    @Override
    public void onEndSubPhase(Board board) { 
        if(subPhase == EncounterSubPhase.ENGAGEMENT_CHECKS){
            board.playersEngageEnemyWithClosestThreat();
        }
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        if(null != subPhase)switch (subPhase) {
            case ENGAGE_ENEMY:
                return board.getPhaseManagerGovenor().getEncounterPhaseManager().
                        setSubPhase(EncounterSubPhase.PREPARATION_ACTIONS);
            case PREPARATION_ACTIONS:
                return board.getPhaseManagerGovenor().getEncounterPhaseManager().
                        setSubPhase(EncounterSubPhase.ENGAGEMENT_CHECKS);
            case ENGAGEMENT_CHECKS:
                return board.getPhaseManagerGovenor().getEncounterPhaseManager().
                        setSubPhase(EncounterSubPhase.PLAYER_ACTIONS);
            case PLAYER_ACTIONS:
                return board.getPhaseManagerGovenor().getCombatPhaseManager().
                        setSubPhase(CombatSubPhase.PREPARATION_ACTIONS);
            default:
                break;
        }
        return this;
    }
    
    public EncounterPhaseManager setSubPhase(EncounterSubPhase newSubPhase){
        subPhase = newSubPhase;
        return this;
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.ENCOUNTER;
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
