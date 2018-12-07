//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.query_components.EnemyQueryEnemyCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyCardViewController {
    
    private EnemyCard card;
    private EnemyQueryEnemyViewController enemyVC;
    private EnemyQueryEnemyCardView view;
    private EnemyQueryActiveState enemyQAS;
    private GameConfiguration config;
    
    public EnemyQueryEnemyCardViewController(Enemy enemy,
            EnemyQueryEnemyViewController enemyVC,
            EnemyQueryActiveState enemyQAS,
            GameConfiguration config){
        this.card = enemy.getCard();
        this.enemyVC = enemyVC;
        this.enemyQAS = enemyQAS;
        view = null;
        this.config = config;
    }
    
    public EnemyQueryEnemyCardView makeView(){
        view = new EnemyQueryEnemyCardView(card.getIdentity(), config);
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public EnemyQueryEnemyCardView updateView(boolean isSelected){
        if(isSelected){
            view.setBorder(BoardActiveState.ACTIVE_BORDER);
        }else{
            view.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        return view;
    }
}
