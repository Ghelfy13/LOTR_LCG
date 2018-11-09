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
    
    public VictoryPointsPile(){
        listOfVPCards = new ArrayList<>();
        totalVPoints = 0;
    }
    
    public void addCard(EncounterCard card){
        listOfVPCards.add(card);
        totalVPoints+= card.getVictoryPoints();
    }
    
    public int getVictoryPoints(){
        return totalVPoints;
    }
    
}
