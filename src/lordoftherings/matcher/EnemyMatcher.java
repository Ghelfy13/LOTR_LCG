//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;

import lordoftherings.PlayerCardType;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class EnemyMatcher implements Matcher<Enemy>{

    @Override
    public boolean matches(Enemy element) {
        return element.getCard().getCardType() == PlayerCardType.ENEMY;
    }
    
}
