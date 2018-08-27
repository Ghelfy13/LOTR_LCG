//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DiscardToHealHandler implements ResultHandler<ArrayList<GameCharacter>>{

    @Override
    public void handle(ArrayList<GameCharacter> result) {
        for(int i = 0; i < result.size(); ++i){
            result.get(i).removeDamage(result.get(i).getDamage());
        }
    }
    
}
