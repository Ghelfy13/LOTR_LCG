//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.characters.GameCharacter;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
//Matcher makes sure that the selected card matches requirements
//ResultHandler is what handles everything once a card is selected
//CancelHandler takes care of the requirements for canceling
public class CharacterQueryHandle extends QueryHandle{
    
    public CharacterQueryHandle( CharacterQueryRequirements requirements,
            ResultHandler<ArrayList<GameCharacter>> resultHandler, CancelHandler cancelHandler){
        super(requirements, resultHandler, cancelHandler);
    }
    
}
