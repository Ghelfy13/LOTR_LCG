//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.event.MouseEvent;

/**
 *
 * @author Amanda
 */
public class SelectableMouseListener<T> extends FocusableMouseListener{
    private SelectableActiveState<T> sas;
    private Selectable<T> selectedElement;
    
    public SelectableMouseListener(SelectableActiveState<T> sas, Selectable<T> selectableElement) {
        super(sas, selectableElement);
        this.sas = sas;
        this.selectedElement = selectableElement;
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        sas.selectOrDeselect(selectedElement);
    }
}
