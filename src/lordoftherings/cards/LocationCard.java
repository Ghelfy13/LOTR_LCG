//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import lordoftherings.PlayerCardType;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EncounterCardModel;

/**
 *
 * @author Amanda
 */
public class LocationCard extends EncounterCard {

    @Override
    public EncounterCardModel getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterOnWhenRevealed(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TODO

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.LOCATION;
    }
}
