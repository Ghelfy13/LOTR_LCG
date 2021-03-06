//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.util.ArrayList;
import javax.swing.JComponent;
import lordoftherings.GameConfiguration;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.EnemyCardView;
import lordoftherings.gui.EncounterZoneComponents.EnemyDamageView;
import lordoftherings.gui.EncounterZoneComponents.EnemyView;
import lordoftherings.manager.actionComponents.Actionable;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.EngagementAreaViewController;

/**
 *
 * @author Amanda
 */
public class EnemyViewController implements Actionable{
    
    private EnemyCardViewController cardVC;
    private EnemyDamageViewController damageVC;
    private EnemyCardView cardView;
    private EnemyDamageView damageView;
    private EnemyView view;
    private Enemy enemy;
    private BoardActiveState bas;
    public static final int ENEMY_Y_VALUE = 200;
    private GameConfiguration config;
    
    public EnemyViewController(BoardActiveState bas, Enemy card, GameConfiguration config){
        this.enemy = card;
        damageVC = new EnemyDamageViewController(config);
        this.bas = bas;
        cardVC = new EnemyCardViewController(card.getCard(), bas, config);
        this.config = config;
    }
    
    public EnemyView makeView(int x, int y){
        view = new EnemyView(this, x, y, config);
        cardView = cardVC.makeView(0, 0);
        cardView.addMouseListener(new ActionableMouseListener(bas, this));
        view.add(cardView);
        damageView = damageVC.makeView(0, ENEMY_Y_VALUE);
        view.add(damageView);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public BoardActiveState getBAS(){
        return bas;
    }
    
    public void updateView(int newX, int newY){
        cardVC.updateView(0,0);
         if(enemy.getCard().getLocation() == LocationOnBoard.FIELD){
            if(enemy.isEnemyStillAttacking()){
                cardVC.getView().setBorder(EngagementAreaViewController.ATTACKING_BORDER);
            }else if( !enemy.hasBeenAttacked()){
                cardVC.getView().setBorder(EngagementAreaViewController.DEFENDING_BORDER);
            }else{
                cardVC.getView().setBorder(BoardActiveState.INACTIVE_BORDER);
            }
        }
        damageVC.updateView(enemy.getDamage());
        view.setLocation(config.scale(newX), config.scale(newY));
    }

    @Override
    public void onSetActionable() {
        if(enemy.isEnemyStillAttacking()){
            cardView.setBorder(EngagementAreaViewController.ATTACKING_ACTIVE_BORDER);
        }else if(!enemy.hasBeenAttacked()){
            cardView.setBorder(EngagementAreaViewController.DEFENDING_ACTIVE_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.ACTIVE_BORDER);
        }
        
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void onUnsetActionable() {
        if(enemy.isEnemyStillAttacking()){
            cardView.setBorder(EngagementAreaViewController.ATTACKING_BORDER);
        }else if(!enemy.hasBeenAttacked()){
            cardView.setBorder(EngagementAreaViewController.DEFENDING_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
    }

    @Override
    public void getActions(ArrayList<Action> listOfActions, int askingID, Board boardState) {
        enemy.getActions(listOfActions, boardState, askingID);
    }

    @Override
    public String getViewingText() {
        return enemy.getCard().getTitle();
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
