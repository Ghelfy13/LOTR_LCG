//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

/**
 *
 * @author Amanda
 */
public class Uncancellable extends CancelHandler {

    @Override
    public boolean canCancel() {
        return false;
    }

    @Override
    protected void dispatchCancel() {
        
    }
    
}
