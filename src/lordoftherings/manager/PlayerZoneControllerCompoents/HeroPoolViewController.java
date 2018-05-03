//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Font;
import lordoftherings.gui.PlayerZoneComponents.HeroPoolView;

/**
 *
 * @author Amanda
 */
public class HeroPoolViewController {
    private HeroViewController heroVC;
    private HeroPoolView view;
    
    public HeroPoolViewController(HeroViewController heroVC){
        this.heroVC = heroVC;
        view = null;
    }
    
    public HeroPoolView makeView(int x, int y, int resources){
        view = new HeroPoolView(x, y, resources, 0);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 16);
        view.setFont(cardFont);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        int numOfResources = heroVC.getResourceOnHero();
        int numOfDamage = heroVC.getDamage();
        view.setText("Resources: " + numOfResources + " Damage: " + numOfDamage);
        view.revalidate();
        view.repaint();
    }
}
