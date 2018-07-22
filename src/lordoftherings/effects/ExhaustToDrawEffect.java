/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.effects;

import lordoftherings.LocationOnBoard;
import lordoftherings.actions.ActionState;
import lordoftherings.actions.BasicEffectAction;
import lordoftherings.actions.EffectAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.SuspensionType;
import lordoftherings.cards.CharacterCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.matcher.PlayerZoneMatcher;
import lordoftherings.transaction_managers.ClearSuspensionHandler;
import lordoftherings.transaction_managers.ExhaustToDrawHandler;
import lordoftherings.transaction_managers.PlayerQueryHandle;
import lordoftherings.transaction_managers.PlayerQueryRequirements;

/**
 *
 * @author Amanda
 */
public class ExhaustToDrawEffect implements Effect {
    
    private int drawValue = 0;
    
    public ExhaustToDrawEffect(int num){
        drawValue = num;
    }

    @Override
    public boolean execute(int askingID, Board board, PlayerCard card) {
        board.addSuspension(SuspensionType.EFFECT);
        CharacterCard character = (CharacterCard) card;
        PlayerZoneMatcher desiredPlayer = new PlayerZoneMatcher();
        PlayerQueryRequirements requirements = new PlayerQueryRequirements(
            desiredPlayer, 1, 1);
        board.handlePlayerZoneQuery(new PlayerQueryHandle(requirements,
            new ExhaustToDrawHandler(board, character, drawValue),
            new ClearSuspensionHandler(board)),
            "Choose a player to draw " + drawValue + " cards.");
        return true;
    }

    @Override
    public ActionState getCurrentState(int askingID, Board board, PlayerCard card) {
        PlayerZone zone = board.getCurrentPlayerZone();
        if(askingID == card.getOwner() && 
                board.getCurrentPlayerNum() == card.getOwner() &&
                board.getPhaseManagerGovenor().isCurrentPhaseActionable() &&
                card.getLocation() == LocationOnBoard.FIELD){
            return ActionState.EXECUTABLE;
        }else if(askingID == card.getOwner() && 
                board.getCurrentPlayerNum() == card.getOwner() &&
                card.getLocation() == LocationOnBoard.FIELD&&
                board.getPhaseManagerGovenor().isCurrentPhaseActionable()){
            return ActionState.VISIBLE;
        }
        return ActionState.NOTAVAILABLE;
    }

    @Override
    public String createDescription(PlayerCard card) {
        return "Exhaust Beravor to allow a selected player to draw 2 cards";
    }

    @Override
    public EffectAction getAction(PlayerCard card) {
        return new BasicEffectAction(card, this);
    }
    
}
