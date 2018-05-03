//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.cards.QuestCard;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class QuestSet {
    private ArrayList<QuestCard> questDeck;
    
    public QuestSet(){
        questDeck = new ArrayList<>();
    }
    
    public QuestSet(ArrayList<QuestCard> newQuestDeck){
        questDeck = newQuestDeck;
    }
    
    public void addQuest(QuestCard newQuest){
        questDeck.add(newQuest);
    }
    
    public ArrayList<QuestCard> getQuestSet(){
        return questDeck;
    }
    
    public QuestCard removeQuest(QuestCard wantedQuest){
        questDeck.remove(wantedQuest);
        return wantedQuest;
    }
}
