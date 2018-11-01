//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.gui.query_components.DiscardPileQueryView;
import lordoftherings.manager.actionComponents.Selectable;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPileViewController implements Selectable<DiscardPile>{
    private DiscardPileQueryView view;
    private DiscardPile pile;
    private DiscardPileQueryActiveState dPileQAS;
    private boolean isSelected;
    
    public DiscardPileQueryPileViewController(DiscardPileQueryActiveState dPileQAS, 
            DiscardPile pile){
        this.pile = pile;
        this.dPileQAS = dPileQAS;
        this.isSelected = false;
    }
    
    public DiscardPileQueryView makeView(int x, int y){
        view = new DiscardPileQueryView();
        view.setVisible(true);
        return view;
    }

    @Override
    public void onSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDeselect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DiscardPile get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getViewingText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
