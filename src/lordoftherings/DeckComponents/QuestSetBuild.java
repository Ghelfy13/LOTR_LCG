//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;

import java.util.ArrayList;
import lordoftherings.cardmodel.QuestCardModel;

/**
 *
 * @author Amanda
 */
public class QuestSetBuild {
    private ArrayList<QuestCardModel> questSetBuild;
    
    public QuestSetBuild(){
        questSetBuild = new ArrayList<>();
    }
    
    public void addListOfQuestCardModels(ArrayList<QuestCardModel> newQuestSet){
        for(int i = 0; i < newQuestSet.size(); ++i){
            questSetBuild.add(newQuestSet.get(i));
        }
    }
    
    public void addQuestCard(QuestCardModel newQuest){
        questSetBuild.add(newQuest);
    }
    
    public QuestCardModel getCardModelAt(int i){
        return questSetBuild.get(i);
    }
    
    public void removeQuestCardAt(int i){
        questSetBuild.remove(i);
    }
    
    public void removeQuestCard(QuestCardModel desiredCard){
        for(int i = 0; i < questSetBuild.size(); ++i){
            if(questSetBuild.get(i) == desiredCard){
                questSetBuild.remove(i);
                return;
            }
        }
    }
    
    public int getSizeOfSet(){
        return questSetBuild.size();
    }
    
}
