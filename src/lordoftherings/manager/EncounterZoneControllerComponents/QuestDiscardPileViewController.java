//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.QuestDiscardPile;
import lordoftherings.cards.QuestCard;
import lordoftherings.gui.EncounterZoneComponents.QuestCardView;
import lordoftherings.gui.EncounterZoneComponents.QuestDiscardPileView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class QuestDiscardPileViewController implements Focusable{

    private QuestDiscardPileView view;
    private QuestDiscardPile discardPile;
    private QuestCard topCard;
    private BoardActiveState bas;
    private EncounterZoneViewController encounterVC;
    private GameConfiguration config;
    
    public QuestDiscardPileViewController(EncounterZoneViewController zoneVC, 
            BoardActiveState bas, QuestDiscardPile discardPile, GameConfiguration config){
        this.bas = bas;
        this.discardPile = discardPile;
        this.encounterVC = zoneVC;
        this.config = config;
    }
    
    public QuestDiscardPileView makeView(int x, int y){
        view = new QuestDiscardPileView(x, y, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.addMouseListener(new FocusableMouseListener(bas, this));
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        topCard = discardPile.getTopCard();
        if(topCard != null){
            view.removeAll();
            QuestCardView topCardView = new QuestCardView(topCard.getIdentity(), 5, 5, config);
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
            return "1 card is in the Quest Discard Pile";
        }else{
            return discardPile.getSize() + " cards in the Quest Discard Pile";
        }
    }
    
}
