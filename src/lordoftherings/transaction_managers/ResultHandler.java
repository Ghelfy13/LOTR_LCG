//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

/**
 *
 * @author Amanda
 */
public interface ResultHandler<T> {
    
    void handle(T result);
}
