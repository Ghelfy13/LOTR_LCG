/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.EventCard;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DiscardToExhaustAndReadyHandler implements ResultHandler<ArrayList<GameCharacter>>{

    private EventCard event;
    private Board board;
    
    public DiscardToExhaustAndReadyHandler(EventCard card, Board board){
        this.event = card;
        this.board = board;
    }
    
    @Override
    public void handle(ArrayList<GameCharacter> result) {
        PlayerZone playerZone = board.getPlayerZoneAt(event.getController());
        playerZone.moveCardToDiscardPile(event);
        playerZone.getHand().removeCard(event);
        board.getCharactersToReady(new ArrayList<GameCharacter>());
         for(int i = 0; i < result.size(); ++i){
            result.get(i).exhaust();
        }
        board.removeRecentSuspension();
    }

    
}
