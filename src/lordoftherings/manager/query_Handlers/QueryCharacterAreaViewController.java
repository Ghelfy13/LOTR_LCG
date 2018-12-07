//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
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
    private CharacterQueryPlayerZoneViewController playerZoneVC;
    private CharacterQueryActiveState charQAS;
    private GameConfiguration config;
    
    public QueryCharacterAreaViewController(
            CharacterQueryPlayerZoneViewController playerZoneVC, 
            HeroArea heroArea,
            AllyArea allyArea,
            CharacterQueryActiveState charQAS, 
            GameConfiguration config){
        this.charQAS = charQAS;
        this.heroArea = heroArea;
        this.allyArea = allyArea;
        this.playerZoneVC = playerZoneVC;
        this.config = config;
        heroAreaVC = new QueryHeroAreaViewController(this, heroArea, charQAS, config);
        allyAreaVC = new QueryAllyZoneViewController(allyArea, this, charQAS, config);
    }
    
    public QueryCharacterAreaView makeView(int x, int y){
        charAreaView = new QueryCharacterAreaView(x, y, config);
        charAreaView.addMouseMotionListener(charQAS.createMouseFollower());
        QueryHeroAreaView heroAreaView = heroAreaVC.makeView(0, 0);
        heroAreaView.setVisible(true);
        charAreaView.add(heroAreaView);
        QueryAllyZoneView allyView = allyAreaVC.makeView(heroAreaView.getLength(), 0);
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
