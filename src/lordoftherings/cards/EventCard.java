//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;
import lordoftherings.cardmodel.EventCardModel;
import lordoftherings.cardmodel.PlayerCardModel;

/**
 *
 * @author Amanda
 */
public class EventCard extends PlayerCard{
    
    private EventCardModel model;
    
    public EventCard(EventCardModel model){
        this.model = model;
    }
    
    public EventCard(EventCardModel model, int controllerID, LocationOnBoard location){
        super(location, controllerID, controllerID);
        this.model = model;
    }
    
    public int getCost(){
        return model.getCost();
    }
    
    public static EventCard get(EventCardModel model){
        EventCard card = new EventCard(model);
        card.instantiateActions();
        return card;
    }

    @Override
    public PlayerCardModel getCardModel() {
        return model;
    }

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.EVENT;
    }
    
}
