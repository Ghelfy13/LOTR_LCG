//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

/**
 *
 * @author Amanda
 */
public abstract class CancelHandler {
    
    public final void cancel(){
        if(!canCancel()){
            throw new RuntimeException();
        }
        dispatchCancel();
    }
    
    public abstract boolean canCancel();
    
    protected abstract void dispatchCancel();
    
    
}
