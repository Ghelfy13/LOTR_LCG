//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class ReadyMatcher implements Matcher<GameCharacter>{

    @Override
    public boolean matches(GameCharacter character) {
        return !character.isExhausted();
    }
    
}
