//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.characters.GameCharacter;
import lordoftherings.characters.Hero;
import lordoftherings.gui.query_components.QueryHeroCardView;
import lordoftherings.gui.query_components.QueryHeroPoolView;
import lordoftherings.gui.query_components.QueryHeroView;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.manager.actionComponents.SelectableMouseListener;

/**
 *
 * @author Amanda
 */
public class QueryHeroViewController implements Selectable<GameCharacter>{
    private QueryHeroAreaViewController areaController;
    private QueryHeroCardViewController cardController;
    private QueryHeroPoolViewController poolController;
    private Hero myHero;
    private QueryHeroView view;
    private CharacterQueryActiveState charQAS;
    private static final int CARD_LENGTH = 200;
    private boolean isSelected;
    
    public QueryHeroViewController(Hero passedInHero, QueryHeroAreaViewController areaController, CharacterQueryActiveState charQAS){
        this.areaController = areaController;
        this.myHero = passedInHero;
        cardController = new QueryHeroCardViewController(myHero, charQAS);
        poolController = new QueryHeroPoolViewController(this);
        this.charQAS = charQAS;
        view = null;
        isSelected = false;
    }
    
    public QueryHeroView makeView(int x, int y){
        view = new QueryHeroView(x, y);
        view.addMouseMotionListener(charQAS.createMouseFollower());
        QueryHeroCardView cardView = cardController.makeView();
        cardView.addMouseListener(new SelectableMouseListener<>(charQAS, this));
        cardView.setVisible(true);
        view.add(cardView);
        QueryHeroPoolView poolView = poolController.makeView(0, CARD_LENGTH, myHero.getNumOfResources(), myHero.getDamage());
        poolView.setVisible(true);
        view.add(poolView);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        poolController.updateView();
        cardController.updateView(isSelected);
        view.revalidate();
        view.repaint();
    }
    
    public QueryHeroView getView(){
        return view;
    }
    
    int getResourceOnHero() {
        return myHero.getNumOfResources();
    }

    int getDamage() {
        return myHero.getDamage();
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
    public Hero get() {
        return myHero;
    }

    @Override
    public String getViewingText() {
        return myHero.getCard().getTitle();
    }
    
    
}
