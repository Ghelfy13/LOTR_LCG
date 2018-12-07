//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.gui.query_components.DiscardPileQueryPileView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Selectable;

/**
 *
 * @author Amanda
 */
public class DiscardPileQueryPileViewController implements Selectable<DiscardPile>{
    private DiscardPileQueryPileView view;
    private DiscardPile pile;
    private DiscardPileQueryActiveState dPileQAS;
    private boolean isSelected;
    private GameConfiguration config;
    
    public DiscardPileQueryPileViewController(DiscardPileQueryActiveState dPileQAS, 
            DiscardPile pile, GameConfiguration config){
        this.pile = pile;
        this.dPileQAS = dPileQAS;
        this.isSelected = false;
        this.config = config;
    }
    
    public DiscardPileQueryPileView makeView(int x, int y){
        view = new DiscardPileQueryPileView(x, y, config);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        if(pile.getSize() == 0){
            view.setVisible(false);
        }
        if(isSelected){
            view.setBorder(BoardActiveState.ACTIVE_BORDER);
        }else{
            view.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        view.revalidate();
        view.repaint();
    }

    @Override
    public void onSelect() {
        isSelected = true;
        updateView();
    }

    @Override
    public void onDeselect() {
        isSelected = false;
        updateView();
    }

    @Override
    public DiscardPile get() {
        return pile;
    }

    @Override
    public String getViewingText() {
        return "There are " + pile.getSize() + "card(s) in the discard pile.";
    }
    
}
