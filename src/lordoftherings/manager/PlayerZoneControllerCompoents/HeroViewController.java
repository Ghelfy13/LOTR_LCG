//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.manager.actionComponents.Actionable;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Hero;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.gui.PlayerZoneComponents.HeroCardView;
import lordoftherings.gui.PlayerZoneComponents.HeroPoolView;
import lordoftherings.gui.PlayerZoneComponents.HeroView;
import lordoftherings.manager.EncounterZoneControllerComponents.LocationViewController;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class HeroViewController implements Actionable{
    
    private CharacterAreaViewController characterAreaVC;
    private HeroCardViewController heroCardVC;
    private HeroPoolViewController heroPoolVC;
    private Hero wantedHero;
    private HeroView view;
    private HeroCardView cardView;
    private BoardActiveState bas;
    public static final int POOL_X = 200;
    
    
    public HeroViewController(Hero passedInHero, CharacterAreaViewController charAreaVC, BoardActiveState bas){
        this.wantedHero = passedInHero;
        this.characterAreaVC = charAreaVC;
        this.view = null;
        this.heroCardVC = new HeroCardViewController(wantedHero, bas);
        this.bas = bas;
    }
    
    public HeroView makeView(int x, int y){
        view = new HeroView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        cardView = heroCardVC.makeView(0,0);
        cardView.addMouseListener(new ActionableMouseListener(bas, this));
        view.add(cardView);
        cardView.setVisible(true);
        heroPoolVC = new HeroPoolViewController(this);
        HeroPoolView poolView = heroPoolVC.makeView(0, POOL_X, wantedHero.getNumOfResources());
        poolView.setVisible(true);
        view.add(poolView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        heroPoolVC.updateView();
        heroCardVC.updateView(0, 0, wantedHero.isExhausted(), wantedHero.isCommitted());
        view.revalidate();
        view.repaint();
    }
    
    public int getResourceOnHero(){
       return wantedHero.getNumOfResources();
    }
    
    public int getDamage(){
        return wantedHero.getDamage();
    }

    @Override
    public String getViewingText() {
        return wantedHero.getCard().getTitle();
    }
    
    @Override
    public void onSetActionable() {
        if(wantedHero.isCommitted()){
            cardView.setBorder(CharacterAreaViewController.COMMIT_ACTIVE_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.ACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void onUnsetActionable() {
        if(wantedHero.isCommitted()){
            cardView.setBorder(CharacterAreaViewController.COMMIT_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState) {
        wantedHero.getCard().getActions(listOfActions, boardState, askingID);
    }

    @Override
    public JComponent getView() {
        return view;
    }

    @Override
    public int getActionsYCoordinate() {
        return LocationViewController.ACTIONS_Y_COORDINATE;
    }
}
