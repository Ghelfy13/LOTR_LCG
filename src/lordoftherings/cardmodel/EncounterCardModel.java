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
    public Identification cardID;
    
    public EncounterCardModel(String title, EncounterType type, String [] traits, Identification cardID){
        this.title = title;
        this.type = type;
        this.traits = traits;
        this.cardID = cardID;
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
}
