//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.manager.actionComponents.SelectableActiveState;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryActiveState extends SelectableActiveState<DiscardPile>{

    private DiscardPileQueryViewController dPileQVC;
    
    public DiscardPileQueryActiveState(DiscardPileQueryViewController discardPileQueryVC) {
        super(discardPileQueryVC);
        this.dPileQVC = discardPileQueryVC;
    }

    @Override
    public void selectOrDeselect(Selectable<DiscardPile> selectedElement) {
        if(dPileQVC.resultContains(selectedElement.get())){
            selectedElement.onDeselect();
            dPileQVC.removeFromResult(selectedElement.get());
        }else{
            if(!dPileQVC.resultIsFull()){
                selectedElement.onSelect();
                dPileQVC.addToResult(selectedElement.get());
            }
        }
        dPileQVC.updateView();
    }
    
}
