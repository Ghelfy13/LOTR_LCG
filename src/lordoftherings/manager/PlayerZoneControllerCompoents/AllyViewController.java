//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.manager.actionComponents.Actionable;
import java.util.ArrayList;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Ally;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.AllyDamageView;
import lordoftherings.gui.PlayerZoneComponents.AllyView;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class AllyViewController implements Actionable {
    
    private AllyCardViewController allyCardVC;
    private Ally wantedAlly;
    private AllyZoneViewController allyZoneVC;
    private AllyView view;
    private AllyDamageView damageView;
    private AllyCardView cardView;
    private BoardActiveState bas;
    public static final int CARD_LENGTH = 250;
    
    
    public AllyViewController(Ally passedInAlly, AllyZoneViewController allyZoneVC, BoardActiveState bas){
        this.wantedAlly = passedInAlly;
        this.view = null;
        this.damageView = null;
        this.allyZoneVC = allyZoneVC;
        this.cardView = null;
        this.bas = bas;
    }
    
    public AllyView makeView(int x, int y){
        view = new AllyView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        allyCardVC = new AllyCardViewController(wantedAlly, this, bas);
        cardView = allyCardVC.makeView(0,0);
        cardView.addMouseListener(new ActionableMouseListener(bas, this));
        view.add(cardView);
        cardView.setVisible(true);
        damageView = new AllyDamageView(0, CARD_LENGTH, 0);
        view.add(damageView);
        damageView.setVisible(true);
        view.setVisible(true);
        return view;
    }
     
    public void updateView(int x, int y){
        allyCardVC.updateView(0, 0, wantedAlly.isExhausted(), wantedAlly.isCommitted());
        damageView.setText("Damage: " + wantedAlly.getDamage());
        view.setVisible(true);
        view.revalidate();
        view.repaint();
    }
    
    public AllyView getView(){
        return view;
    }

    @Override
    public String getViewingText() {
        return wantedAlly.getCard().getTitle();
    }

   @Override
    public void onSetActionable() {
        if(wantedAlly.isCommitted()){
            cardView.setBorder(CharacterAreaViewController.COMMIT_ACTIVE_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.ACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void onUnsetActionable() {
        if(wantedAlly.isCommitted()){
            cardView.setBorder(CharacterAreaViewController.COMMIT_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState) {
        wantedAlly.getCard().getActions(listOfActions, boardState, askingID);
    }
}
