//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Font;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.query_components.QueryHeroPoolView;

/**
 *
 * @author Amanda
 */
public class QueryHeroPoolViewController {
    private QueryHeroViewController controller;
    private QueryHeroPoolView poolView;
    private GameConfiguration config;
    
    public QueryHeroPoolViewController(QueryHeroViewController controller, 
            GameConfiguration config){
        this.controller = controller;
        poolView = null;
        this.config = config;
    }
    
    public QueryHeroPoolView makeView(int x, int y, int resources, int damage){
        poolView = new QueryHeroPoolView(x, y, resources, damage, config);
        poolView.setVisible(true);
        return poolView;
    }
    
    public void updateView(){
        int numOfResources = controller.getResourceOnHero();
        int numOfDamage = controller.getDamage();
        poolView.setText("Resources: " + numOfResources + "  Damage: " + numOfDamage);
        poolView.revalidate();
        poolView.repaint();
    }
    
}
