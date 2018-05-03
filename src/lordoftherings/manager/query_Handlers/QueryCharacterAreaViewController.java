//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.AllyArea;
import lordoftherings.boardcomponents.HeroArea;
import lordoftherings.gui.query_components.QueryAllyZoneView;
import lordoftherings.gui.query_components.QueryCharacterAreaView;
import lordoftherings.gui.query_components.QueryHeroAreaView;
import lordoftherings.transaction_managers.CharacterQueryHandle;

/**
 *
 * @author Amanda
 */
public class QueryCharacterAreaViewController {
    private QueryHeroAreaViewController heroAreaVC;
    private QueryAllyZoneViewController allyAreaVC;
    private HeroArea heroArea;
    private AllyArea allyArea;
    private QueryCharacterAreaView charAreaView;
    private QueryPlayerZoneViewController playerZoneVC;
    private CharacterQueryActiveState charQAS;
   
    
    public QueryCharacterAreaViewController(
            QueryPlayerZoneViewController playerZoneVC, 
            HeroArea heroArea,
            AllyArea allyArea,
            CharacterQueryActiveState charQAS){
        this.charQAS = charQAS;
        this.heroArea = heroArea;
        this.allyArea = allyArea;
        this.playerZoneVC = playerZoneVC;
        heroAreaVC = new QueryHeroAreaViewController(this, heroArea, charQAS);
        allyAreaVC = new QueryAllyZoneViewController(allyArea, this, charQAS);
    }
    
    public QueryCharacterAreaView makeView(int x, int y){
        charAreaView = new QueryCharacterAreaView(x, y);
        charAreaView.addMouseMotionListener(charQAS.createMouseFollower());
        QueryHeroAreaView areaView = heroAreaVC.makeView(0, 0);
        areaView.setVisible(true);
        charAreaView.add(areaView);
        QueryAllyZoneView allyView = allyAreaVC.makeView(areaView.getLength() + 40, 0);
        allyView.setVisible(true);
        charAreaView.add(allyView);
        return charAreaView;
    }
    
    public void updateView(){
        heroAreaVC.updateView();
        allyAreaVC.updateView();
    }
    
    public CharacterQueryHandle getHandle(){
        return playerZoneVC.getHandle();
    }
    
}
