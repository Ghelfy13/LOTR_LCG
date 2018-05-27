//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.characters.GameCharacter;
import lordoftherings.matcher.Matcher;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
//Matcher makes sure that the selected card matches requirements
//ResultHandler is what handles everything once a card is selected
//CancelHandler takes care of the requirements for canceling
public class CharacterQueryHandle {
    private CharacterQueryRequirements requirements;
    private ResultHandler<ArrayList<GameCharacter>> resultHandler;
    private CancelHandler cancelHandler;
    
    public CharacterQueryHandle( CharacterQueryRequirements requirements,
            ResultHandler<ArrayList<GameCharacter>> resultHandler, CancelHandler cancelHandler){
        this.requirements = requirements;
        this.resultHandler = resultHandler;
        this.cancelHandler = cancelHandler;
    }
    
    public Matcher<GameCharacter> getMatcher(){
        return requirements.getMatcher();
    }
    
    public int getMin(){
        return requirements.getMin();
    }
    
    public int getMax(){
        return requirements.getMax();
    }
    
    public ResultHandler<ArrayList<GameCharacter>> getResultHandler(){
        return resultHandler;
    }
    
    public CancelHandler getCancelHandler(){
        return cancelHandler;
    }

    public CharacterQueryRequirements getRequirements() {
        return requirements;
    }
}
