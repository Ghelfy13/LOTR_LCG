//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.EncounterType;
import lordoftherings.game_engine.GameData.Identification;
import lordoftherings.cards.LocationCard;

/**
 *
 * @author Amanda
 */
public class LocationCardModel extends EncounterCardModel{
    private int threat;
    private int questPoints;
            
    
    public LocationCardModel(String title, EncounterType type, String[] traits,
            Identification cardID, int threat, int questPoints, int victoryPoints, 
            String effect, ArrayList<KeyWords> keyWords) {
        super(title, type, traits, cardID, effect, victoryPoints, keyWords);
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
                + threat + "\n" + "Quest Points:  " + questPoints + "\n" + "Victory Points: " + victoryPoints + '\n' + effect;
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

    public boolean hasVictoryPoints(){
        return victoryPoints != 0;
    }
    
    public int getVictoryPoints(){
        return victoryPoints;
    }
    
    public String geTitle() {
        return title;
    }

    @Override
    public String getEffect() {
        return effect;
    }
}
