//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;

import lordoftherings.PlayerCardType;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class HeroMatcher implements Matcher<GameCharacter>{
    
    @Override
    public boolean matches(GameCharacter character) {
        return character.getCard().getCardType() == PlayerCardType.HERO;
    }
    
}
