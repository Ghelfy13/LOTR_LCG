//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Font;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.query_components.QueryHeroPoolView;

/**
 *
 * @author Amanda
 */
public class QueryHeroPoolViewController {
    private QueryHeroViewController controller;
    private QueryHeroPoolView poolView;
    
    public QueryHeroPoolViewController(QueryHeroViewController controller){
        this.controller = controller;
        poolView = null;
    }
    
    public QueryHeroPoolView makeView(int x, int y, int resources, int damage){
        poolView = new QueryHeroPoolView(x, y, resources, damage);
        poolView.setFont(AllyCardView.CARD_FONT);
        poolView.setVisible(true);
        return poolView;
    }
    
    public void updateView(){
        int numOfResources = controller.getResourceOnHero();
        int numOfDamage = controller.getDamage();
        poolView.setText("Resources: " + numOfResources + " Damage: " + numOfDamage);
        poolView.revalidate();
        poolView.repaint();
    }
    
}
