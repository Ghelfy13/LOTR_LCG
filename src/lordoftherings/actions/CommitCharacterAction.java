//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.PhaseManager.QuestSubPhase;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.CharacterArea;
import lordoftherings.cards.CharacterCard;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class CommitCharacterAction extends Action{
    CharacterCard wantedCard;
    
    public CommitCharacterAction(CharacterCard cardToCommit){
        super(getDescription(cardToCommit));
        this.wantedCard = cardToCommit;
    }
    
    private static String getDescription(CharacterCard card){
        return "Commit " + card.getTitle();
    }

    @Override
    public boolean execute(int askingID, Board boardState) {
        CharacterArea charArea = boardState.getPlayerZoneAt(wantedCard.getController()).getCharZone();
        GameCharacter character = charArea.getCharacterForCard(wantedCard);
        character.commit();
        character.exhaust();
        return true;
    }

    @Override
    public void updateActionState(int askingID, Board boardState) {
        CharacterArea charArea = boardState.getPlayerZoneAt(wantedCard.getController()).getCharZone();
        GameCharacter character = charArea.getCharacterForCard(wantedCard);
        if(boardState.getCurrentPhase() == GamePhase.QUEST && boardState.getCurrentSubPhase() == QuestSubPhase.COMMIT_CHARACTERS &&
                character != null && !character.isCommitted() && !character.isExhausted()){
            state = ActionState.EXECUTABLE;
        }else{
            state = ActionState.NOTAVAILABLE;
        }
        
    }
    
}
