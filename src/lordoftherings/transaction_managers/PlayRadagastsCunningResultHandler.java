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
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class PlayRadagastsCunningResultHandler implements ResultHandler<ArrayList<Enemy>>{
    
    private Board board;
    private EventCard event;
    
    public PlayRadagastsCunningResultHandler(EventCard event, Board board){
        this.board = board;
        this.event = event;
    }

    @Override
    public void handle(ArrayList<Enemy> result) {
        for(int i = 0; i < result.size(); ++i){
            result.get(i).doesntContributeThreat();
        }
        PlayerZone zone = board.getPlayerZoneAt(event.getController());
        zone.moveCardToDiscardPile(event);
        zone.getHand().removeCard(event);
    }

    
    
}
