//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.GameConfiguration;
import lordoftherings.characters.Hero;
import lordoftherings.boardcomponents.HeroArea;
import lordoftherings.gui.PlayerZoneComponents.HeroZoneView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class HeroZoneViewController {
    
    private HeroArea heroArea;
    private CharacterAreaViewController characterVC;
    private HeroZoneView view;
    private HeroViewController heroVC;
    private BoardActiveState bas;
    private static final int HERO_VIEW_WIDTH = 200;
    private HashMap<Hero, HeroViewController> controllerMap;
    private GameConfiguration config;
    
    
    public HeroZoneViewController(CharacterAreaViewController characterVC, 
            HeroArea heroArea, BoardActiveState bas, GameConfiguration config){
        this.characterVC = characterVC;
        this.heroArea = heroArea;
        this.heroVC = null;
        this.controllerMap = new HashMap<>();
        this.bas = bas;
        this.config = config;
    }
    
    public HeroZoneView makeView(int x, int y){
        int numOfHeros = heroArea.getNumOfHeros();
        view = new HeroZoneView(x, y, numOfHeros, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        int num = 0;
        while(num < numOfHeros){
            Hero hero = heroArea.getHeroAt(num);
            heroVC = new HeroViewController(hero, characterVC, bas, config);
            hero.setPositionInHeroArea(num);
            controllerMap.put(hero, heroVC);
            view.add(heroVC.makeView(num*(HERO_VIEW_WIDTH + 5), 0));
            ++num;
        }
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        HashSet<Hero> deadHeros = new HashSet<>();
        for(Map.Entry<Hero, HeroViewController> entry: controllerMap.entrySet()){
            if(heroArea.findHero(entry.getKey()) == -1){
                deadHeros.add(entry.getKey());
                view.remove(entry.getValue().getView());
                
            }
        }
        for(Hero deadHero: deadHeros){
            controllerMap.remove(deadHero);
        }
        for(int i = 0; i < heroArea.getNumOfHeros(); ++i){
            Hero current = heroArea.getHeroAt(i);
            HeroViewController heroVC = controllerMap.get(current);
            heroVC.updateView();
        }
        view.revalidate();
        view.repaint();
    }
    
    public HeroZoneView getView(){
        return view;
    }
    
}
