//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public class PlayerQueryRequirements extends QueryRequirements{
    
    public PlayerQueryRequirements(Matcher<PlayerZone> zoneMatcher, int min, int max){
        super(zoneMatcher, min, max);
    }
    
}
