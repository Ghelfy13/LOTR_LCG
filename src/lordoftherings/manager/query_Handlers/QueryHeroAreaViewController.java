//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.HeroArea;
import lordoftherings.characters.Hero;
import lordoftherings.gui.query_components.QueryHeroAreaView;
import lordoftherings.transaction_managers.CharacterQueryHandle;
/**
 *
 * @author Amanda
 */
class QueryHeroAreaViewController {
    
    private HeroArea heroZone;
    private QueryCharacterAreaViewController charQueryVC;
    private QueryHeroAreaView view;
    private QueryHeroViewController heroVC;
    private CharacterQueryActiveState charQAS;
    private static final int HERO_VIEW_WIDTH = 205;
    private HashMap<Hero, QueryHeroViewController> controllerMap;
    private GameConfiguration config;
    
    public QueryHeroAreaViewController(QueryCharacterAreaViewController charAreaVC, 
            HeroArea heroZone, CharacterQueryActiveState charQAS, GameConfiguration config){
        this.heroZone = heroZone;
        this.charQueryVC = charAreaVC;
        this.charQAS = charQAS;
        controllerMap = new HashMap<>();
        this.config = config;
    }
    
    public QueryHeroAreaView makeView(int x, int y){
        CharacterQueryHandle handle = charQueryVC.getHandle();
        int length = heroZone.getNumOfInitialHeros();
        view = new QueryHeroAreaView(x, y, length, config);
        view.addMouseMotionListener(charQAS.createMouseFollower());
        for(int i = 0; i < heroZone.getNumOfHeros(); ++i){
            Hero current = heroZone.getHeroAt(i);
            if(handle.getMatcher().matches(current)){
                heroVC = new QueryHeroViewController(current, this, charQAS, config);
                controllerMap.put(current, heroVC);
                view.add(heroVC.makeView(
                        current.getPositionInHeroArea()*(HERO_VIEW_WIDTH), 0));
            }
        }
        view.setVisible(true);
        return view;
        
    }
    
    public QueryHeroAreaView getView(){
        return view;
    }
    
    public void updateView(){
        HashSet<Hero> herosToRemove = new HashSet<>();
        for(Map.Entry<Hero, QueryHeroViewController> entry: controllerMap.entrySet()){
            if(heroZone.getIndexOfHero(entry.getKey()) == -1){
                herosToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        for(Hero deadAlly: herosToRemove){
            controllerMap.remove(deadAlly);
        }
        
        for(int i = 0; i < heroZone.getNumOfHeros(); ++i){
            Hero existingHero = heroZone.getHeroAt(i);
            QueryHeroViewController heroVC = controllerMap.get(existingHero);
            if(heroVC != null){
                heroVC.updateView();
            }
        }
        view.revalidate();
        view.repaint();
    }
}
