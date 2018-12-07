//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.characters.Ally;
import lordoftherings.gui.query_components.QueryAllyCardView;
import lordoftherings.gui.query_components.QueryAllyDamageView;
import lordoftherings.gui.query_components.QueryAllyView;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.characters.GameCharacter;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.manager.EncounterZoneControllerComponents.EnemyViewController.ENEMY_Y_VALUE;
import lordoftherings.manager.actionComponents.SelectableMouseListener;

/**
 *
 * @author Amanda
 */
public class QueryAllyViewController implements Selectable<GameCharacter>{
    private QueryAllyView view;
    private Ally currentAlly;
    private QueryAllyCardViewController cardVC;
    private QueryAllyDamageView damageView;
    private CharacterQueryActiveState charQAS;
    private boolean isSelected;
    private GameConfiguration config;
    
    public QueryAllyViewController(Ally currentAlly, 
            CharacterQueryActiveState charQAS, 
            GameConfiguration config){
        this.currentAlly = currentAlly;
        view = null;
        this.cardVC = new QueryAllyCardViewController(
                currentAlly, this, charQAS, config);
        this.damageView = null;
        this.charQAS = charQAS;
        this.config = config;
    }
    
    public QueryAllyView makeView(int x, int y){
        view = new QueryAllyView(x, y, config);
        view.addMouseMotionListener(charQAS.createMouseFollower());
        QueryAllyCardView cardView = cardVC.makeView(currentAlly.isExhausted());
        cardView.addMouseListener(new SelectableMouseListener(charQAS, this));
        view.add(cardView);
        cardView.setVisible(true);
        damageView = new QueryAllyDamageView(0, ENEMY_Y_VALUE, 0, config);
        damageView.setVisible(true);
        view.add(damageView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        cardVC.updateView(isSelected);
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
    public Ally get() {
        return currentAlly;
    }

    @Override
    public String getViewingText() {
        return currentAlly.getCard().getTitle();
    }

    public QueryAllyView getView() {
        return view;
    }
}
