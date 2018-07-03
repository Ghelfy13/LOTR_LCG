//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.matcher.Matcher;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class CharacterQueryRequirements extends QueryRequirements{
        
    public CharacterQueryRequirements(Matcher<GameCharacter> matcher, int min, int max){
        super(matcher, min, max);
    }
}
