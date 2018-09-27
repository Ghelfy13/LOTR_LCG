//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.effects;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.characters.Enemy;
import lordoftherings.characters.GameCharacter;
import lordoftherings.matcher.ReadyMatcher;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.CharacterQueryRequirements;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.PlayToQuickStrikeResultHandler;

/**
 *
 * @author Amanda
 */
public class PlayToQuickStrikeEffect implements Effect{

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        EventCard event = (EventCard) card;
        ReadyMatcher readiedChar = new ReadyMatcher();
        ResultList list = new ResultList(board, event);
        CharacterQueryRequirements requirements = new CharacterQueryRequirements(
            readiedChar, 1,1);
        board.handleCharacterQuery(
            new CharacterQueryHandle(requirements,
                new PlayToQuickStrikeResultHandler(board, list),
                new ClearSuspensionHandler(board)),
                "Choose a character to exhaust and attack an enemy engaged with you.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        EventCard event = (EventCard) card;
        if(event.getController() == askingID && 
                board.getPhaseManagerGovenor().isCurrentPhaseActionable()&&
                board.getCurrentPlayerZone().getHerosResources()>= event.getCost() &&
                event.getLocation() == LocationOnBoard.HAND){
            return ActionState.EXECUTABLE;
        }else if(event.getController() == askingID && 
                board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
                event.getLocation() == LocationOnBoard.HAND){
            return ActionState.VISIBLE;
        }else{
            return ActionState.NOTAVAILABLE;
        }
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Play to exhaust a character you control to immediate attack any chosen enemy egaged with you.";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
    public static class ResultList{
        private EventCard card;
        private ArrayList<GameCharacter> charToExhaust;
        private ArrayList<Enemy> enemyToAttack;
        private Board board;
        private int attack;
        public ResultList(Board board, EventCard card){
            this.board = board;
            this.card = card;
            attack = 0;
        }
        
        public void executeActions(){
            
            if(charToExhaust != null){
                for(int i = 0; i < charToExhaust.size(); ++i){
                    charToExhaust.get(i).exhaust();
                    attack = charToExhaust.get(i).getAttackWithMods();
                }
            }
            if(enemyToAttack != null){
                for(int i = 0; i < enemyToAttack.size(); ++i){
                    Enemy current = enemyToAttack.get(i);
                    int damageDealt = attack - current.getDefense();
                    if(damageDealt > 0){
                        current.assignDamage(damageDealt);
                    }
                }
            }
            if(card != null){
                PlayerZone zone = board.getPlayerZoneAt(card.getController());
                zone.getHand().removeCard(card);
                zone.moveCardToDiscardPile(card);
                zone.cleanUpEngagedEnemyArea();
            }
        }
        
        public void addCharsToExhaust(ArrayList<GameCharacter> exhaustList){
            charToExhaust = exhaustList;
        }
        
        public void addEnemyToAttack(ArrayList<Enemy> readyList){
            enemyToAttack = readyList;
        }
        
        public EventCard getEventCard(){
            return card;
        }
        
        public ArrayList<GameCharacter> getListToExhaust(){
            return charToExhaust;
        }
        
        public ArrayList<Enemy> getListToAttack(){
            return enemyToAttack;
        }
    }
    
}
