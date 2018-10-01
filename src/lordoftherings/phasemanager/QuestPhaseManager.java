//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.phasemanager;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class QuestPhaseManager implements PhaseManager{
    private QuestSubPhase subPhase;
    private boolean isActionable;
    
    public QuestPhaseManager(){
        this.subPhase = QuestSubPhase.COMMIT_CHARACTERS;
        this.isActionable = true;
    }
    
    public QuestPhaseManager setSubPhase(QuestSubPhase phase){
        subPhase = phase;
        return this;
    }
    
    @Override
    public void onStartSubPhase(Board board) {
        switch (subPhase){
            case COMMIT_CHARACTERS:
                isActionable = true;
                break;
            case ENCOUNTER_DECK_REVEAL:
                board.drawFromEncounterDeck();
                isActionable = false;
                break;
            case RESOLVE_QUEST:
                board.resolveQuest();
                board.hasGameEnded();
                isActionable = false;
                break;
            case PLAYER_ACTIONS:
                isActionable = true;
                break;
            case COUNTER_ACTIONS:
                isActionable = true;
                break;
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
                    board.getPlayerZoneAt(i).clearUpPhaseModifiers();
                    board.getEncounterZone().getStagingArea().resetThreatContribution();
                } 
               return;
            default:
                return;
        }
    }

    @Override
    public PhaseManager getNextPhase(Board board) {
        switch (subPhase){
            case COMMIT_CHARACTERS:
                return board.getPhaseManagerGovenor().getQuestPhaseManager().
                        setSubPhase(QuestSubPhase.ENCOUNTER_DECK_REVEAL);
            case ENCOUNTER_DECK_REVEAL:
                return board.getPhaseManagerGovenor().getQuestPhaseManager().
                        setSubPhase(QuestSubPhase.COUNTER_ACTIONS);
            case COUNTER_ACTIONS:
                return board.getPhaseManagerGovenor().getQuestPhaseManager().
                        setSubPhase(QuestSubPhase.RESOLVE_QUEST);
            case RESOLVE_QUEST:
                return board.getPhaseManagerGovenor().getQuestPhaseManager().
                        setSubPhase(QuestSubPhase.PLAYER_ACTIONS);
            case PLAYER_ACTIONS:
                return board.getPhaseManagerGovenor().getTravelPhaseManager().
                        setSubPhase(TravelSubPhase.SELECT_ACTIVE_LOCATION);
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

    @Override
    public boolean isActionable() {
        return isActionable;
    }
    
}
