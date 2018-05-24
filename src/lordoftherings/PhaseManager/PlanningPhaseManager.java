//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.PhaseManager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class PlanningPhaseManager implements PhaseManager{
    private PlanningSubPhase subPhase;
    
    public PlanningPhaseManager(){
        this.subPhase = PlanningSubPhase.PLAY_ALLIES_AND_ATTACHMENTS;
    }
    
    @Override
    public void onStartSubPhase(Board board) {}
    
    @Override
    public void onEndSubPhase(Board board) {}

    @Override
    public PhaseManager getNextPhase(Board board) {
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
        //TODO
    }
    
}
