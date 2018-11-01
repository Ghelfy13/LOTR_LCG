//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.matcher.Matcher;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryRequirements extends QueryRequirements{
    
    public DiscardPileQueryRequirements(Matcher<DiscardPile> matcher, int min, int max) {
        super(matcher, min, max);
    }
    
}
