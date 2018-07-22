/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.PlayerCardType;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.CharacterCard;
import lordoftherings.characters.Ally;
import lordoftherings.characters.Hero;

/**
 *
 * @author Amanda
 */
public class ExhaustToDrawHandler implements ResultHandler<ArrayList<PlayerZone>>{
    private Board board;
    private CharacterCard character;
    private int numOfCards;
    
    public ExhaustToDrawHandler(Board board, CharacterCard card, int num){
        this.board = board;
        this.character = card;
        this.numOfCards = num;
    }
    
    @Override
    public void handle(ArrayList<PlayerZone> result) {
        for(int i = 0; i < result.size(); ++i){
            for(int j = 0; j < numOfCards; ++j){
                result.get(i).drawCardFromDeckAddToHand();
            }
        }
        PlayerCardType cardType = character.getCardType();
        Character charToExhaust;
        if(cardType == PlayerCardType.ALLY){
            Ally myAlly = board.getCurrentPlayerZone().getCharZone().findAlly(character);
            myAlly.exhaust();
        }else{
            Hero myHero = board.getCurrentPlayerZone().getCharZone().findHero(character);
            myHero.exhaust();
        }
        board.removeRecentSuspension();
    }
    
}
