//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.EncounterType;
import lordoftherings.Identification;
import lordoftherings.cards.EncounterCard;

/**
 *
 * @author Amanda
 */
public abstract class EncounterCardModel {
    protected String title;
    protected EncounterType type;
    protected String[] traits;
    protected Identification cardID;
    protected String effect;
    protected int victoryPoints;
    
    public EncounterCardModel(String title, 
            EncounterType type, 
            String [] traits, 
            Identification cardID,
            String effect,
            int victoryPoints){
        this.title = title;
        this.type = type;
        this.traits = traits;
        this.cardID = cardID;
        this.effect = effect;
        this.victoryPoints = victoryPoints;
    }
    
    protected String identifyTraits(){
        StringBuilder myString = new StringBuilder();
        int length = traits.length;
        for(int i = 0; i < length; ++i){
            if( i == length -1){
                myString.append(traits[i] + '\n');
            }else{
                myString.append(traits[i] + ", ");
            }
        }
        return myString.toString();
    }
    
    public abstract String identify();
    
    public abstract int getThreat();
    
    public abstract Identification getCardID();
    
    public abstract EncounterCard createCard();
    
    public abstract String getEffect();
    
    public abstract int getVictoryPoints();
}
