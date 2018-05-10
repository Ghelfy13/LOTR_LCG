//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.characters.Ally;
import lordoftherings.gui.query_components.QueryAllyCardView;
import lordoftherings.gui.query_components.QueryAllyDamageView;
import lordoftherings.gui.query_components.QueryAllyView;
import lordoftherings.manager.PlayerZoneControllerCompoents.AllyViewController;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.characters.GameCharacter;
import lordoftherings.gui.PlayerZoneComponents.AllyView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.SelectableMouseListener;

/**
 *
 * @author Amanda
 */
public class QueryAllyViewController implements Selectable<GameCharacter>{
    private QueryAllyView view;
    private QueryAllyZoneViewController allyZoneVC;
    private Ally currentAlly;
    private QueryAllyCardViewController cardVC;
    private QueryAllyDamageView damageView;
    private CharacterQueryActiveState charQAS;
    private boolean isSelected;
    
    public QueryAllyViewController(Ally currentAlly, QueryAllyZoneViewController allyZoneVC, CharacterQueryActiveState charQAS){
        this.allyZoneVC = allyZoneVC;
        this.currentAlly = currentAlly;
        view = null;
        this.cardVC = new QueryAllyCardViewController(currentAlly, this, charQAS);
        this.damageView = null;
        this.charQAS = charQAS;
    }
    
    public QueryAllyView makeView(int x, int y){
        view = new QueryAllyView(x, y);
        view.addMouseMotionListener(charQAS.createMouseFollower());
        QueryAllyCardView cardView = cardVC.makeView(0, 0);
        cardView.addMouseListener(new SelectableMouseListener(charQAS, this));
        view.add(cardView);
        cardView.setVisible(true);
        damageView = new QueryAllyDamageView(0, HandCardView.CARD_HEIGHT, 0);
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
