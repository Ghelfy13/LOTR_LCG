//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HeroPoolView;

/**
 *
 * @author Amanda
 */
public class HeroPoolViewController {
    private HeroViewController heroVC;
    private HeroPoolView view;
    private GameConfiguration config;
    
    public HeroPoolViewController(HeroViewController heroVC, GameConfiguration config){
        this.heroVC = heroVC;
        view = null;
        this.config = config;
    }
    
    public HeroPoolView makeView(int x, int y, int resources){
        view = new HeroPoolView(x, y, resources, 0, config);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        int numOfResources = heroVC.getResourceOnHero();
        int numOfDamage = heroVC.getDamage();
        view.setText("Resources: " + numOfResources + "  Damage: " + numOfDamage);
        view.revalidate();
        view.repaint();
    }
}
