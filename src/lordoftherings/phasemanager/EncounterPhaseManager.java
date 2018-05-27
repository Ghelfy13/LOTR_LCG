//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class EncounterPhaseManager implements PhaseManager{
    private EncounterSubPhase subPhase;
    
    public EncounterPhaseManager(){
        subPhase = EncounterSubPhase.ENGAGE_ENEMY;
    }

    @Override
    public void onStartSubPhase(Board board) {
        if(subPhase == EncounterSubPhase.ENGAGE_ENEMY){
            int numOfPlayerZones = board.getNumOfPlayerZones();
            for(int i = 0; i < numOfPlayerZones; ++i){
                board.getPlayerZoneAt(i).setEngagedEnemyYet(false);
            }
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
        
        if(subPhase == EncounterSubPhase.ENGAGE_ENEMY){
            return board.getPhaseManagerGovenor().getEncounterPhaseManager().
                    setSubPhase(EncounterSubPhase.ENGAGEMENT_CHECKS);
        }
        else if(subPhase == EncounterSubPhase.ENGAGEMENT_CHECKS){
            return board.getPhaseManagerGovenor().getCombatPhaseManager().
                    setSubPhase(CombatSubPhase.RESOLVE_ENEMY_ATTACKS);
        }
        throw new RuntimeException();
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
    
}
