//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.EncounterType;
import lordoftherings.Identification;
import lordoftherings.cards.EncounterCard;

/**
 *
 * @author Amanda
 */
public class LocationCardModel extends EncounterCardModel{
    //TODO
    
    public LocationCardModel(String title, EncounterType type, String[] traits, Identification cardID) {
        super(title, type, traits, cardID);
    }

    @Override
    public String identify() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getThreat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Identification getCardID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EncounterCard createCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TODO
}
