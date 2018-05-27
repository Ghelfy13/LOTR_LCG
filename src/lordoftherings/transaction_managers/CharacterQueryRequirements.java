//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.matcher.Matcher;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class CharacterQueryRequirements {
    private Matcher<GameCharacter> matcher;
    private int min;
    private int max;
    
    public CharacterQueryRequirements(Matcher<GameCharacter> matcher, int min, int max){
        this.matcher = matcher;
        this.min = min;
        this.max = max;
    }
    
    public Matcher<GameCharacter> getMatcher(){
        return matcher;
    }
    
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public boolean accepts(ArrayList<GameCharacter> potentialResult){
        if(potentialResult.size() > max || potentialResult.size() < min){
            return false;
        }
        for(int i = 0; i < potentialResult.size(); ++i){
            if(!matcher.matches(potentialResult.get(i))){
                return false;
            }
        }
        return true;
    }
}
