//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class PlanningPhaseManager implements PhaseManager{
    private PlanningSubPhase subPhase;
    private boolean isActionable;
    
    public PlanningPhaseManager(){
        this.subPhase = PlanningSubPhase.PLAY_ALLIES_AND_ATTACHMENTS;
        this.isActionable = false;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        switch(subPhase){
            case PLAY_ALLIES_AND_ATTACHMENTS:
                isActionable = false;
                break;
            case PLAYER_ACTIONS:
                isActionable = true;
                break;
        }
                
    }
    
    @Override
    public void onEndSubPhase(Board board) {}

    @Override
    public PhaseManager getNextPhase(Board board) {
        if(subPhase == PlanningSubPhase.PLAY_ALLIES_AND_ATTACHMENTS){
            return board.getPhaseManagerGovenor().getPlanningPhaseManager().
                    setSubPhase(PlanningSubPhase.PLAYER_ACTIONS);
        }
        return board.getPhaseManagerGovenor().
                getQuestPhaseManager().setSubPhase(QuestSubPhase.COMMIT_CHARACTERS);
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.PLANNING;
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

    public PhaseManager setSubPhase(PlanningSubPhase planningSubPhase) {
        subPhase = planningSubPhase;
        return this;
    }
    
}
