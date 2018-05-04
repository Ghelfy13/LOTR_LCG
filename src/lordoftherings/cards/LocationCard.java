//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import lordoftherings.PlayerCardType;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cardmodel.LocationCardModel;

/**
 *
 * @author Amanda
 */

public class LocationCard extends EncounterCard {
    private LocationCardModel cardModel;
    
    public LocationCard(LocationCardModel model){
        this.cardModel = model;
    }
    
    @Override
    public EncounterCardModel getModel() {
        return cardModel;
    }

    @Override
    public void afterOnWhenRevealed(Board board) {
        //TODO
    }

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.LOCATION;
    }

    public String getTitle() {
        return cardModel.geTitle();
    }
}
