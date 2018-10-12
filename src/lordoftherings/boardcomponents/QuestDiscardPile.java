//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.cards.QuestCard;

/**
 *
 * @author Amanda
 */
public class QuestDiscardPile {
    private ArrayList<QuestCard> discardPile;
    private int ownerID = -5;
    
    public QuestDiscardPile(){
        discardPile = new ArrayList<>();
    }
    
    public int getOwnerId(){
        return ownerID;
    }
    
    public void addCard(QuestCard completedQuest){
        discardPile.add(completedQuest);
    }
    
    public QuestCard getTopCard(){
        if(!discardPile.isEmpty()){
            return discardPile.get(discardPile.size() -1);
        }
        return null;
    }
}
