//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

/**
 *
 * @author Amanda
 */
public abstract class SelectableActiveState<T> extends FocusableActiveState{
    
    public SelectableActiveState(GlobalViewController globalVC) {
        super(globalVC);
    }
    
    public abstract void selectOrDeselect(Selectable<T> selectedElement);
    
}
