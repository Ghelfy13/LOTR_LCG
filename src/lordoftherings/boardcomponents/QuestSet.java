//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.DeckComponents.QuestSetBuild;
import lordoftherings.cards.QuestCard;

/**
 *
 * @author Amanda
 */
public class QuestSet {
    private QuestCard[] questSet;
    private QuestCard currentQuest;
    private boolean completedQuests;
    
    public QuestSet(QuestSetBuild setComponents){
        questSet = new QuestCard[setComponents.getSizeOfSet()];
        completedQuests = false;
        for(int i = 0; i < questSet.length; ++i){
            QuestCard card = new QuestCard(setComponents.getCardModelAt(i));
            questSet[i] = card;
        }
    }
    
    public QuestCard getQuestCardAt(int i){
        return questSet[i];
    }
    
    public int getSizeOfSet(){
        return questSet.length;
    }
    
    public boolean hasCompletedQuests(){
        return completedQuests;
    }
    
    public QuestCard getNextQuest(){//can return null
        if(currentQuest == null){
            currentQuest = questSet[0];
            return currentQuest;
        }
        else if(currentQuest == questSet[questSet.length -1]){
            completedQuests = true;
            return currentQuest;
        }
        for(int i = 0; i < questSet.length; ++i){
            if(questSet[i] == currentQuest && i != questSet.length){
                currentQuest = questSet[i];
                return currentQuest;
            }
        }
        currentQuest = null;
        return currentQuest;
    }
    
}
