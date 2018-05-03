//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.manager.actionComponents.Actionable;
import java.awt.Font;
import java.util.ArrayList;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.PlayerCard;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class HandCardViewController implements Actionable{
    private HandViewController handvc;
    private PlayerCard card;
    private HandCardView view;
    private BoardActiveState bas;
    
    
    public HandCardViewController(HandViewController hvc, PlayerCard wantedCard, BoardActiveState bas){
        this.handvc = hvc;
        this.card = wantedCard;
        this.bas = bas;
    }
    
    public HandCardView makeView(int x, int y){
        view = new HandCardView(this, card.getIdentity(),x,y);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setEditable(false);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 14);
        view.setFont(cardFont);
        view.setVisible(true);
        return view;
    }
    
    public HandCardView getView(){
        return view;
    }
    public BoardActiveState getBoardActiveStateController(){
        return bas;
    }
    
    void updateView(int newX, int newY) {
        view.setLocation(newX, newY);
    }
    
    @Override
    public String getViewingText() {
        return card.getTitle();
    }

    @Override
    public void onSetActionable() {
        view.setBorder(BoardActiveState.ACTIVE_BORDER);
        view.revalidate();
        view.repaint();
    }

    @Override
    public void onUnsetActionable() {
        view.setBorder(BoardActiveState.INACTIVE_BORDER);
        view.revalidate();
        view.repaint();
    }

    @Override
    public void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState) {
        card.getActions(listOfActions, boardState, askingID);
    }
    
}
