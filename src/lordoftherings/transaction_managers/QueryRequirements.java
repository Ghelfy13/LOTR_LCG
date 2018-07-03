//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public abstract class QueryRequirements <T>{
    private Matcher<T> matcher;
    private int min;
    private int max;
    
    public QueryRequirements(Matcher<T> matcher, int min, int max){
        this.matcher = matcher;
        this.min = min;
        this.max = max;
    }
    
    public Matcher<T> getMatcher(){
        return matcher;
    }
    
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public boolean accepts(ArrayList<T> potentialResult){
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
