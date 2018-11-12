//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.cards.EncounterCard;

/**
 *
 * @author Amanda
 */
public class VictoryPointsPile {
    
    private ArrayList<EncounterCard> listOfVPCards;
    private int totalVPoints;
    private Board board;
    
    public VictoryPointsPile(Board board){
        listOfVPCards = new ArrayList<>();
        totalVPoints = 0;
        this.board = board;
    }
    
    public void addCard(EncounterCard card){
        listOfVPCards.add(card);
        totalVPoints+= card.getVictoryPoints();
    }
    
    public int getVictoryPoints(){
        return totalVPoints;
    }
    
    public EncounterCard getTopCard(){
        if(listOfVPCards.isEmpty()){
            return null;
        }
        return listOfVPCards.get(listOfVPCards.size() -1);
    }
    
    public int size(){
        return listOfVPCards.size();
    }
    
}
