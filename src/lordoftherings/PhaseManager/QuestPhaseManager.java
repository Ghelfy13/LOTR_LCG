//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.PhaseManager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class QuestPhaseManager implements PhaseManager{
    private QuestSubPhase subPhase;
    
    public QuestPhaseManager(){
        this.subPhase = QuestSubPhase.ENCOUNTER_DECK_REVEAL;
    }
    
    public QuestPhaseManager setSubPhase(QuestSubPhase phase){
        subPhase = phase;
        return this;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        switch (subPhase){
            case ENCOUNTER_DECK_REVEAL:
                board.drawFromEncounterDeck();
                return;
            case RESOLVE_QUEST:
                board.resolveQuest();
                return;
            case SELECT_ACTIVE_LOCATION:
                return;
            default:
                return;
        }
    }

    @Override
    public void onEndSubPhase(Board board) {
        switch(subPhase){
            case COMMIT_CHARACTERS:
                return;
            case ENCOUNTER_DECK_REVEAL:
                return;
            case RESOLVE_QUEST:
               for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                    board.getPlayerZoneAt(i).unsetCommittedCharacters();
                } 
               return;
            case SELECT_ACTIVE_LOCATION:
                return;
        }
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        switch (subPhase){
            case COMMIT_CHARACTERS:
                return board.getQuestPhaseManager().setSubPhase(QuestSubPhase.ENCOUNTER_DECK_REVEAL);
            case ENCOUNTER_DECK_REVEAL:
                return board.getQuestPhaseManager().setSubPhase(QuestSubPhase.RESOLVE_QUEST);
            case RESOLVE_QUEST:
                return board.getQuestPhaseManager().setSubPhase(QuestSubPhase.SELECT_ACTIVE_LOCATION);
            case SELECT_ACTIVE_LOCATION:
                return board.getEncounterPhaseManager();
            default:
                return null;
        }
    }

    @Override
    public GamePhase getPhase() {
        return GamePhase.QUEST;
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
