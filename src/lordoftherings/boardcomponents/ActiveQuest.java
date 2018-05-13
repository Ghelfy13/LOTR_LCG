//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.DeckComponents.Quest;

/**
 *
 * @author Amanda
 */
public class ActiveQuest {
    private Quest currentQuest;
    
    public ActiveQuest(Quest current){
        this.currentQuest = current;
    }
    
    public void addTokens(int num){
        currentQuest.addTravelTokens(num);
    }
    
    public boolean isComplete(){
        return currentQuest.haveEnoughTokens();
    }
    
    public Quest getQuest(){
        return currentQuest;
    }
}
