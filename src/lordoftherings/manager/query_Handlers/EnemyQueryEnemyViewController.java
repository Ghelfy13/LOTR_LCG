//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.characters.Enemy;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.gui.query_components.EnemyQueryEnemyCardView;
import lordoftherings.gui.query_components.EnemyQueryEnemyDamageView;
import lordoftherings.gui.query_components.EnemyQueryEnemyView;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.manager.actionComponents.SelectableMouseListener;

/**
 *
 * @author Amanda
 */
public class EnemyQueryEnemyViewController implements Selectable<Enemy>{
    
    private EnemyQueryEnemyView view;
    private Enemy enemy;
    private EnemyQueryEnemyCardViewController cardVC;
    private EnemyQueryEnemyDamageView damageView;
    private EnemyQueryActiveState enemyQAS;
    private boolean isSelected;

    public EnemyQueryEnemyViewController(Enemy currentEnemy, 
            EnemyQueryActiveState enemyQAS){
        this.enemy = enemy;
        this.enemyQAS = enemyQAS;
        cardVC = new EnemyQueryEnemyCardViewController(enemy, this, enemyQAS);
        damageView = null;
        isSelected = false;
    }
    
    public EnemyQueryEnemyView makeView(int x, int y){
        view = new EnemyQueryEnemyView(x, y);
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        EnemyQueryEnemyCardView cardView = cardVC.makeView();
        cardView.addMouseListener(new SelectableMouseListener(enemyQAS, this));
        view.add(cardView);
        cardView.setVisible(true);
        damageView = new EnemyQueryEnemyDamageView(0, HandCardView.CARD_HEIGHT, 0);
        damageView.setVisible(true);
        view.add(damageView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        cardVC.updateView(isSelected);
    }
    
    public EnemyQueryEnemyView getView(){
        return view;
    }
    
    @Override
    public void onSelect() {
        isSelected = true;
        updateView();
    }

    @Override
    public void onDeselect() {
        isSelected = false;
        updateView();
    }

    @Override
    public Enemy get() {
        return enemy;
    }

    @Override
    public String getViewingText() {
        return enemy.getCard().getTitle();
    }
    
}
