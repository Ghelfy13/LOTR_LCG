//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.matcher.ReadyHeroMatcher;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.DiscardToExhaustAndReadyHandler;

/**
 *
 * @author Amanda
 */
public class DiscardToExhaustAndReadyEffect implements Effect{

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        ReadyHeroMatcher exhaustedHero = new ReadyHeroMatcher();
        CharacterQueryRequirements requirements = new CharacterQueryRequirements(
            exhaustedHero, 1, 1);
        board.handleCharacterQuery(new CharacterQueryHandle(requirements, 
            new DiscardToExhaustAndReadyHandler(event, board),
            new ClearSuspensionHandler(board)),
            "Choose a hero you controll to then ready a different hero.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        if(askingID == board.getCurrentPlayerNum() && card.getOwner() == askingID
                && board.getPhaseManagerGovenor().isCurrentPhaseActionable()){
            return ActionState.EXECUTABLE;
        }else if(askingID == board.getCurrentPlayerNum() && card.getOwner() == askingID){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Discard " +card.getTitle() + 
                " to exhaust a hero you control to ready a different hero.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card,this);
    }
    
}
