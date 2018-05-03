//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.boardcomponents.EncounterDiscardPile;
import lordoftherings.cards.EncounterCard;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardCardView;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardPileViewController implements Focusable{
    
    private EncounterDiscardPile discardPile;
    private EncounterZoneViewController encounterZoneVC;
    private EncounterDiscardPileView view;
    private EncounterCard topCard;
    private BoardActiveState bas;
    
    public EncounterDiscardPileViewController(EncounterZoneViewController zoneVC, 
            BoardActiveState bas, EncounterDiscardPile discardPile){
        this.encounterZoneVC = zoneVC;
        this.discardPile = discardPile;
        this.bas = bas;
        this.view = null;
        this.topCard = null;
    }
    
    public EncounterDiscardPileView makeView(int x, int y){
        view = new EncounterDiscardPileView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.addMouseListener(new FocusableMouseListener(bas, this));
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        topCard = discardPile.getTopCard();
        if(topCard != null){
            EncounterDiscardCardView topCardView = new EncounterDiscardCardView(5, 5, topCard.getIdentity());
            topCardView.addMouseMotionListener(bas.createMouseFollower());
            topCardView.addMouseListener(new FocusableMouseListener(bas, this));
            topCardView.setVisible(true);
            view.add(topCardView);
        }
        view.revalidate();
        view.repaint();
    }
    
    
    @Override
    public String getViewingText() {
        if(discardPile.getSize() == 1){
            return "1 card is in Encounter Discard Pile";
        }else{
            return discardPile.getSize() + " cards in Encounter Discard Pile";
        }
    }
    
}
