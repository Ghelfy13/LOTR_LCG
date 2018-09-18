//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.characters.Enemy;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public class EnemyQueryRequirements extends QueryRequirements{
    
    public EnemyQueryRequirements(Matcher<Enemy> matcher, int min, int max) {
        super(matcher, min, max);
    }
    
}
