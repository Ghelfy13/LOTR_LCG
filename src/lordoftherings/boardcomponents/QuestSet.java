//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.deckcomponents.QuestSetBuild;
import lordoftherings.cards.QuestCard;

/**
 *
 * @author Amanda
 */
public class QuestSet {
    private ArrayList<QuestCard> questSet;
    private QuestCard currentQuest;
    
    public QuestSet(QuestSetBuild setComponents){
        questSet = new ArrayList<>();
        for(int i = 0; i < setComponents.getSizeOfSet(); ++i){
            QuestCard card = new QuestCard(setComponents.getCardModelAt(i));
            questSet.add(card);
        }
    }
    
    public QuestCard getQuestCardAt(int i){
        return questSet.get(i);
    }
    
    public int getSizeOfSet(){
        return questSet.size();
    }
    
    public boolean hasCompletedQuests(){
        return currentQuest == null && questSet.isEmpty();
    }
    
    public QuestCard getNextQuest(){//can return null
        if(questSet.isEmpty()){
            currentQuest = null;
        }
        else{
            currentQuest = questSet.remove(0);
        }
        return currentQuest;
    }
    
}
