//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.DiscardPile;
import lordoftherings.cards.PlayerCard;
import lordoftherings.gui.PlayerZoneComponents.DiscardCardView;
import lordoftherings.gui.PlayerZoneComponents.DiscardPileView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class DiscardPileViewController implements Focusable{
    private DiscardPile dPile;
    private PlayerZoneViewController playerZoneVC;
    private DiscardPileView view;
    private PlayerCard topCard;
    private BoardActiveState bas;
    public static final int DISCARD_DISTANCE = 5;
    private GameConfiguration config;
    
    public DiscardPileViewController(DiscardPile dPile, PlayerZoneViewController zoneVC, 
            BoardActiveState bas, GameConfiguration config){
        this.dPile = dPile;
        this.playerZoneVC = zoneVC;
        this.view = null;
        this.topCard = null;
        this.bas = bas;
        this.config = config;
    }
    
    public DiscardPileView makeView(int x, int y){
        view = new DiscardPileView(x, y, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.addMouseListener(new FocusableMouseListener(bas, this));
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        topCard = dPile.getTopCard();
        
        if(topCard != null){
            DiscardCardView topCardView = new DiscardCardView(DISCARD_DISTANCE,
                    DISCARD_DISTANCE, topCard.getIdentity(), config);
            topCardView.addMouseMotionListener(bas.createMouseFollower());
            topCardView.addMouseListener(new FocusableMouseListener(bas, this));
            topCardView.setVisible(true);
            view.removeAll();
            view.add(topCardView);
        }
        view.revalidate();
        view.repaint();
    }

    @Override
    public String getViewingText() {
        if(dPile.getSize() == 1){
            return "1 card in Discard Pile";
        }else{
            return dPile.getSize() + " cards in Discard Pile";
        }
        
    }
}
