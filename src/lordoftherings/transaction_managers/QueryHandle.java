/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public abstract class QueryHandle<T> {
    
    private QueryRequirements<T> requirements;
    private ResultHandler<ArrayList<T>> resultHandler;
    private CancelHandler cancelHandler;
    
     public QueryHandle(QueryRequirements requirements,
            ResultHandler<ArrayList<T>> resultHandler, CancelHandler cancelHandler){
        this.requirements = requirements;
        this.resultHandler = resultHandler;
        this.cancelHandler = cancelHandler;
    }
     
     public Matcher<T> getMatcher(){
        return requirements.getMatcher();
    }
    
    public int getMin(){
        return requirements.getMin();
    }
    
    public int getMax(){
        return requirements.getMax();
    }
    
    public ResultHandler<ArrayList<T>> getResultHandler(){
        return resultHandler;
    }
    
    public CancelHandler getCancelHandler(){
        return cancelHandler;
    }

    public QueryRequirements getRequirements() {
        return requirements;
    }
}
