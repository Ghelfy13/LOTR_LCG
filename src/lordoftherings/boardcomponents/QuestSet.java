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
    private int numOfQuestsLeft;
    
    public QuestSet(QuestSetBuild setComponents){
        questSet = new QuestCard[setComponents.getSizeOfSet()];
        completedQuests = false;
        for(int i = 0; i < questSet.length; ++i){
            QuestCard card = new QuestCard(setComponents.getCardModelAt(i));
            questSet[i] = card;
        }
        numOfQuestsLeft = questSet.length;
    }
    
    public QuestCard getQuestCardAt(int i){
        return questSet[i];
    }
    
    public int getSizeOfSet(){
        return questSet.length;
    }
    
    public int getNumOfQuestsLeft(){
        return numOfQuestsLeft;
    }
    
    public boolean hasCompletedQuests(){
        return completedQuests;
    }
    
    public QuestCard getNextQuest(){//can return null
        if(currentQuest == null){
            currentQuest = questSet[0];
            --numOfQuestsLeft;
            return currentQuest;
        }
        for(int i = 0; i < questSet.length; ++i){
            if(questSet[i] == currentQuest && i != questSet.length){
                currentQuest = questSet[i];
                --numOfQuestsLeft;
                return currentQuest;
            }
        }
        completedQuests = true;
        currentQuest = null;
        return currentQuest;
    }
    
}
