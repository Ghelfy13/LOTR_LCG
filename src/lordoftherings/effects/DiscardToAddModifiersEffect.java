//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.GameCharacter;
import lordoftherings.matcher.AnyMatcher;
import lordoftherings.modifiers.Modifier;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.DiscardToAddModifiersHandler;

/**
 *
 * @author Amanda
 */
public class DiscardToAddModifiersEffect implements Effect{
    ArrayList<Modifier> modifiers;
    
    public DiscardToAddModifiersEffect(ArrayList<Modifier> mods){
        modifiers = mods;
    }

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        AnyMatcher<GameCharacter> desiredCharacter = new AnyMatcher();
        CharacterQueryRequirements requirements = new CharacterQueryRequirements(
            desiredCharacter, 1, 1);
        board.handleCharacterQuery(new CharacterQueryHandle(requirements, 
            new DiscardToAddModifiersHandler(board, event, modifiers),
            new ClearSuspensionHandler(board)),
            "Choose a character to raise some of their stats.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        if(askingID == card.getOwner() && 
                board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
                board.getCurrentPlayerZone().getHerosResources() >= card.getCost() &&
                card.getLocation() == LocationOnBoard.HAND){
            return ActionState.EXECUTABLE;
        }else if(askingID == card.getOwner() && 
                board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
                card.getLocation() == LocationOnBoard.HAND){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Play this card, and then discard, to add modifications to a characters status.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
