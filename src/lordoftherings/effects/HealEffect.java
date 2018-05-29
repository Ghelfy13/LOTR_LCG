//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.CharacterArea;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.CharacterCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.Ally;
import lordoftherings.characters.GameCharacter;
import lordoftherings.matcher.HeroMatcher;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.ExhaustToHealHandler;

/**
 *
 * @author Amanda
 */
public class HealEffect implements Effect{
    private int healingValue;
   
    public HealEffect(int healingNum) {
        this.healingValue = healingNum;
    }
    
    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        CharacterCard charCard = (CharacterCard) card;
        Ally healer = board.getPlayerZoneAt(card.getController()).getCharZone().findAlly(charCard);
        HeroMatcher damagedHero = new HeroMatcher();
        CharacterQueryRequirements requirements = 
                new CharacterQueryRequirements(damagedHero, 1,1);
        board.handleCharacterQuery(
            new CharacterQueryHandle(
                requirements, 
                new ExhaustToHealHandler(board, healer, healingValue),
                new ClearSuspensionHandler(board)),
            "Choose a hero to heal " + healingValue + "\n" + " damage");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        CharacterCard charCard = (CharacterCard) card;
        CharacterArea charArea = board.getPlayerZoneAt(charCard.getController()).getCharZone();
        GameCharacter healer = charArea.getCharacterFromCard(charCard);
        if(healer != null && !healer.isExhausted() && board.getPhaseManagerGovenor().
                isCurrentPhaseActionable()&& askingID == card.getController() &&
                card.getLocation() == LocationOnBoard.FIELD){
            return ActionState.EXECUTABLE;
        }else if(board.getPhaseManagerGovenor().isCurrentPhaseActionable() && 
                card.getLocation() == LocationOnBoard.FIELD){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
         return "Heal two damage by exhausting " + card.getTitle();
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
