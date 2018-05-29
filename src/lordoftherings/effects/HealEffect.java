//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.actions.ActionState;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.CharacterArea;
import lordoftherings.cards.CharacterCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class HealEffect implements Effect{
   
    public HealEffect() {
        
    }
    
    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        CharacterCard charCard = (CharacterCard) card;
        CharacterArea charArea = board.getPlayerZoneAt(charCard.getController()).getCharZone();
        GameCharacter healer = charArea.getCharacterFromCard(charCard);
        //if(!healer.isExhausted())
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
         return "Heal two damage by exhausting " + card.getTitle();
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        //TODO
        return null;
    }
    
}
