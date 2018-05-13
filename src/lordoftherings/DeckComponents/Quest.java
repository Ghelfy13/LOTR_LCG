//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;

import lordoftherings.cards.QuestCard;

/**
 *
 * @author Amanda
 */
public class Quest {
    private QuestCard sireCard;
    private int travelTokens;
    private boolean isCompleted;
    
    public Quest(QuestCard newQuest){
        this.sireCard = newQuest;
        travelTokens = 0;
        isCompleted = false;
    }
    
    public QuestCard getQuestCard(){
        return sireCard;
    }
    
    public int getNumOfTokens(){
        return travelTokens;
    }
    
    public void addTravelTokens(int numOfTokens){
        travelTokens += numOfTokens;
    }
    
    public void removeTravelTokens(int numOfTokens){
        if(numOfTokens >= travelTokens){
            travelTokens = 0;
        }else{
            travelTokens -= numOfTokens;
        }
    }
    
    public boolean haveEnoughTokens(){
        if(travelTokens >= sireCard.getQuestPoints()){
            isCompleted  = true;
        }
        return isCompleted;
    }
    
    public String getInformation(){
         return sireCard.getModel().identify();
    }
}
