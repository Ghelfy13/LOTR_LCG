//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.EncounterType;
import lordoftherings.Identification;
import lordoftherings.cards.LocationCard;

/**
 *
 * @author Amanda
 */
public class LocationCardModel extends EncounterCardModel{
    private int threat;
    private int questPoints;
    
    public LocationCardModel(String title, EncounterType type, String[] traits,
            Identification cardID, int threat, int questPoints, String effect) {
        super(title, type, traits, cardID, effect);
        this.threat = threat;
        this.questPoints = questPoints;
    }
    
    public int getQuestPoints(){
        return questPoints;
    }

    @Override
    public String identify() {
        return title.toUpperCase()+ "\n" + "\n" + "Encounter Type: " + type + "\n" 
                + "Traits: " + identifyTraits() + "Threat Value: "
                + threat + "\n" + "Quest Points:  " + questPoints + "\n" + '\n' + effect;
    }

    @Override
    public int getThreat(){
        return threat;
    }

    @Override
    public Identification getCardID() {
        return cardID;
    }

    @Override
    public LocationCard createCard() {
        return new LocationCard(this);
    }

    public String geTitle() {
        return title;
    }

    @Override
    public String getEffect() {
        return effect;
    }
}
