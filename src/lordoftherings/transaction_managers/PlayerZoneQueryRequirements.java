//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public class PlayerZoneQueryRequirements {
    private Matcher<PlayerZone> matcher;
    private int min;
    private int max;
    
    public PlayerZoneQueryRequirements(Matcher<PlayerZone> zoneMatcher, int min, int max){
        this.matcher = zoneMatcher;
        this.min = min;
        this.max = max;
    }
    
    public Matcher<PlayerZone> getMatcher(){
        return matcher;
    }
    
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public boolean accepts(ArrayList<PlayerZone> potentialResult){
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