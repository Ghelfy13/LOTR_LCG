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
import lordoftherings.modifiers.Modifier;

/**
 *
 * @author Amanda
 */
public class DiscardToAddModifiersHandler implements ResultHandler<ArrayList<GameCharacter>> {
    
    private Board board;
    private EventCard event;
    private ArrayList<Modifier> mods;
    
    public DiscardToAddModifiersHandler(Board board, EventCard card, 
            ArrayList<Modifier> mods){
        this.board = board;
        this.event = card;
        this.mods = mods;
    }

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        for(int i = 0; i < result.size(); ++i){
            for(int j = 0; j < mods.size(); ++j){
                result.get(i).addModifier(mods.get(j));
            }
        }
        PlayerZone playerZone = board.getPlayerZoneAt(event.getController());
        playerZone.payForCard(event.getCost());
        playerZone.moveCardToDiscardPile(event);
        playerZone.getHand().removeCard(event);
        board.removeTopSuspension();
    }
}
