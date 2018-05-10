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
    
    public QuestSet(QuestSetBuild setComponents){
        questSet = new QuestCard[setComponents.getSizeOfSet()];
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
    
}
