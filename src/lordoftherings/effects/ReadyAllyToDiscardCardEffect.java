//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.matcher.ExhaustedMatcher;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.DiscardToReadyHandler;

/**
 *
 * @author Amanda
 */
public class ReadyAllyToDiscardCardEffect implements Effect{
    
    public ReadyAllyToDiscardCardEffect(){};

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard eventCard = (EventCard) card;
        ExhaustedMatcher exhaustedAlly = new ExhaustedMatcher();
        CharacterQueryRequirements requirements = 
                new CharacterQueryRequirements(exhaustedAlly, 1, 1);
        board.handleCharacterQuery(
                new CharacterQueryHandle(requirements, 
                new DiscardToReadyHandler(board, eventCard), 
                new ClearSuspensionHandler(board)),
        "Choose an exhausted Ally to ready");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        PlayerZone zone = board.getPlayerZoneAt(card.getController());
        if(card.getLocation() == LocationOnBoard.HAND && 
            board.getPlayerZoneAt(card.getController()).getHerosResources()>0 &&
            board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
            askingID == card.getController() && !zone.getAllies().isEmpty()){
            return ActionState.EXECUTABLE;
        }else if(card.getLocation() == LocationOnBoard.HAND){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Play this card to ready an exhausted Ally";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
