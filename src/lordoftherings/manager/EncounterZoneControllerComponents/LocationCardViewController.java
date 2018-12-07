//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.cards.LocationCard;
import lordoftherings.gui.EncounterZoneComponents.LocationCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class LocationCardViewController {
    private LocationCardView cardView;
    private LocationCard card;
    private String locationInfo;
    private BoardActiveState bas;
    private GameConfiguration config;
    
    public LocationCardViewController(LocationCard card, BoardActiveState bas, GameConfiguration config){
        this.card = card;
        locationInfo = card.getIdentity();
        this.bas = bas;
        this.config = config;
    }
    
    public LocationCardView makeView(int x, int y){
        cardView = new LocationCardView(this, locationInfo, x, y, config);
        cardView.addMouseMotionListener(bas.createMouseFollower());
        cardView.setVisible(true);
        return cardView;
    }
    
    public void updateView(){
        cardView.setVisible(true);
        cardView.revalidate();
        cardView.repaint();
    }
    
    public LocationCardView getView(){
        return cardView;
    }
    
}
