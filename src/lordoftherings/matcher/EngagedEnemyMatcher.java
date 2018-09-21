//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;

import lordoftherings.LocationOnBoard;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class EngagedEnemyMatcher implements Matcher<Enemy>{

    @Override
    public boolean matches(Enemy element) {
        return element.getLocationOnBoard() == LocationOnBoard.FIELD;
    }
    
}
