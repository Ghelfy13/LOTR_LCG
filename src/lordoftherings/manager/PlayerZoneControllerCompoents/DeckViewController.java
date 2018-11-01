//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.boardcomponents.PlayerDeck;
import lordoftherings.gui.PlayerZoneComponents.DeckViewParent;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;

/**
 *
 * @author Amanda
 */
public class DeckViewController implements Focusable{
    private PlayerDeck playerDeck;
    private PlayerZoneViewController playerZoneVC;
    private DeckViewParent deckParent;
    private BoardActiveState bas;
    
    public DeckViewController(){
       deckParent = new DeckViewParent(this);
    }
    
    public DeckViewController(PlayerZoneViewController playerZoneViewController, PlayerDeck playerDeck, BoardActiveState bas){
        this.playerDeck = playerDeck;
        this.playerZoneVC = playerZoneViewController;
        this.deckParent = null;
        this.bas = bas;
    }
           
    public DeckViewParent makeView(int x, int y){
        deckParent = new DeckViewParent(this);
        deckParent.addMouseMotionListener(bas.createMouseFollower());
        deckParent.setLocation(x,y);
        deckParent.setVisible(true);
        deckParent.getView().setVisible(true);
        deckParent.getView().addMouseMotionListener(bas.createMouseFollower());
        return deckParent;
    }
    
    public BoardActiveState getBoardActiveStateController(){
        return bas;
    }
    
    public void updateView(){
        if(playerDeck.getSize() == 0){
            deckParent.getView().setVisible(false);
        }else{
            deckParent.getView().setVisible(true);
        }
    }
    
    @Override
    public String getViewingText() {
        return playerDeck.getSize()+" cards remain";
    }
    
    
}
