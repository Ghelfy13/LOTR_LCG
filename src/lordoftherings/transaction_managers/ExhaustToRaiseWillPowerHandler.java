//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.CharacterCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.Ally;
import lordoftherings.modifiers.Modifier;

/**
 *
 * @author Amanda
 */
public class ExhaustToRaiseWillPowerHandler implements ResultHandler<ArrayList<PlayerZone>>{
    //Currently only handles ally cards. 
    private Board board;
    private PlayerCard card;
    private Modifier mod;
    
    public ExhaustToRaiseWillPowerHandler(Board board, PlayerCard card, 
            Modifier mod){
        this.board = board;
        this.card = card;
        this.mod = mod;
    }
    
    @Override
    public void handle(ArrayList<PlayerZone> result) {
        CharacterCard character = (CharacterCard) card;
        PlayerZone current = result.get(0);
        Ally myAlly = current.getCharZone().findAlly(character);
        myAlly.exhaust();
        current.getCharZone().addModifierToAll(mod);
    }
    
}
