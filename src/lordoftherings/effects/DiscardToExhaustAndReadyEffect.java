//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import java.util.ArrayList;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.GameCharacter;
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
        ResultList list = new ResultList(board, event);
        CharacterQueryRequirements requirements = new CharacterQueryRequirements(
            exhaustedHero, 1, 1);
        board.handleCharacterQuery(new CharacterQueryHandle(requirements, 
            new DiscardToExhaustAndReadyHandler(board, list),
            new ClearSuspensionHandler(board)),
            "Choose a hero you control to exhaust so that a different hero can ready.");
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
    
    public static class ResultList{
        private EventCard card;
        private ArrayList<GameCharacter> charToExhaust;
        private ArrayList<GameCharacter> charToReady;
        private Board board;
        
        public ResultList(Board board, EventCard card){
            this.board = board;
            this.card = card;
        }
        
        public void executeActions(){
            if(card != null){
                PlayerZone zone = board.getPlayerZoneAt(card.getController());
                zone.getHand().removeCard(card);
                zone.moveCardToDiscardPile(card);
            }
            if(charToExhaust != null){
                for(int i = 0; i < charToExhaust.size(); ++i){
                    charToExhaust.get(i).exhaust();
                }
            }
            if(charToReady != null){
                for(int i = 0; i < charToReady.size(); ++i){
                    charToReady.get(i).ready();
                }
            }
        }
        
        public void addCharsToExhaust(ArrayList<GameCharacter> exhaustList){
            charToExhaust = exhaustList;
        }
        
        public void addCharsToReady(ArrayList<GameCharacter> readyList){
            charToReady = readyList;
        }
        
        public EventCard getEventCard(){
            return card;
        }
        
        public ArrayList<GameCharacter> getListToExhaust(){
            return charToExhaust;
        }
        
        public ArrayList<GameCharacter> getListToReady(){
            return charToReady;
        }
    }
    
}
