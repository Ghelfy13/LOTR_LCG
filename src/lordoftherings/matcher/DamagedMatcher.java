//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;

import lordoftherings.PlayerCardType;
import lordoftherings.characters.GameCharacter;

/**
 *
 * @author Amanda
 */
public class DamagedMatcher implements Matcher<GameCharacter>{

    @Override
    public boolean matches(GameCharacter element) {
        return ((element.getCard().getCardType() == PlayerCardType.ALLY ||
                element.getCard().getCardType() == PlayerCardType.HERO) && 
                element.getDamage()>0);
    }
    
}
