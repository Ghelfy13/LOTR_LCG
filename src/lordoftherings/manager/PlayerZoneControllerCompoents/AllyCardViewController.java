//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.characters.Ally;
import lordoftherings.cards.AllyCard;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
class AllyCardViewController{
    private AllyCard card;
    private AllyViewController allyVC;
    private AllyCardView view;
    private BoardActiveState bas;
    private static final int CARD_HEIGHT = 250;
    private static final int CARD_WIDTH = 180;
    
    public AllyCardViewController(Ally wantedCard, AllyViewController allyVC, BoardActiveState bas){
        this.card = wantedCard.getCard();
        this.allyVC = allyVC;
        this.view = null;
        this.bas = bas;
    }
    
    public AllyCardView makeView(int x, int y){
        view = new AllyCardView(card.getIdentity(),x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setEditable(false);
        return view;
    }
    
    public void updateView(int x, int y, boolean isExhausted, boolean isCommitted){
        if(isExhausted){
            view.setBounds(x, y + CARD_HEIGHT - CARD_WIDTH, CARD_HEIGHT, CARD_WIDTH);
        }else if(!isExhausted){
            view.setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
        }if(isCommitted){
            view.setBorder(CharacterAreaViewController.COMMIT_BORDER);
        }else if(!isCommitted){
            view.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        view.revalidate();
        view.repaint();
    }
}
