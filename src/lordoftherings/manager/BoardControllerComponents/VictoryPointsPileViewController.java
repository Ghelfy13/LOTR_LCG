//Copyright Amanda V. Harris 2018-present. All Rights Reserved.    

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.boardcomponents.VictoryPointsPile;
import lordoftherings.cards.EncounterCard;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardCardView;
import lordoftherings.gui.VictoryPointsPileView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class VictoryPointsPileViewController implements Focusable{
    
    private BoardViewController boardVC;
    private VictoryPointsPile pile;
    private VictoryPointsPileView view;
    private BoardActiveState bas;
    private EncounterCard topCard;
    
    
    public VictoryPointsPileViewController(BoardViewController boardVC, 
            BoardActiveState bas){
        this.boardVC = boardVC;
        pile = boardVC.getBoard().getVPPile();
        this.bas = bas;
        topCard = null;
    }
    
    public VictoryPointsPileView makeView(int x, int y){
        view = new VictoryPointsPileView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.addMouseListener(new FocusableMouseListener(bas, this));
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        topCard = pile.getTopCard();
        if(topCard != null){
            view.removeAll();
            EncounterDiscardCardView topCardView = 
                    new EncounterDiscardCardView(5, 5, topCard.getIdentity());
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
        if(pile.size() == 1){
            return "1 card in the Victory Points Pile.";
        }
        return pile.size() + " cards in the Victory Points Pile.";
    }
    
}
