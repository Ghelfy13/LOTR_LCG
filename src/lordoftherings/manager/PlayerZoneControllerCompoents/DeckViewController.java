//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.GameConfiguration;
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
    private GameConfiguration config;
    
    public DeckViewController(){}
    
    public DeckViewController(PlayerZoneViewController playerZoneViewController, 
            PlayerDeck playerDeck, BoardActiveState bas, GameConfiguration config){
        this.playerDeck = playerDeck;
        this.playerZoneVC = playerZoneViewController;
        this.deckParent = null;
        this.bas = bas;
        this.config = config;
    }
           
    public DeckViewParent makeView(int x, int y){
        deckParent = new DeckViewParent(this, x, y, config);
        deckParent.addMouseMotionListener(bas.createMouseFollower());
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
