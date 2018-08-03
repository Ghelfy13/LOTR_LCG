//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;

/**
 *
 * @author Amanda
 */
public class AnyMatcher<T> implements Matcher<T> {

    @Override
    public boolean matches(T element) {
        return true;
    }
    
}
