//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.Identification;
import lordoftherings.cards.PlayerCard;
import lordoftherings.PlayerCardType;
import lordoftherings.DeckComponents.SphereOfInfluence;

/**
 *
 * @author Amanda
 */
public abstract class PlayerCardModel {
    protected String title; 
    protected SphereOfInfluence sphereOfInfluence;
    protected PlayerCardType type;
    protected String [] trait;
    protected Identification cardID;
    
    protected PlayerCardModel(
        String title, 
        SphereOfInfluence sphereOfInfluence,
        PlayerCardType type, 
        String [] trait, 
        Identification cardID){
        this.title = title;
        this.sphereOfInfluence = sphereOfInfluence;
        this.type = type;
        this.trait = trait;
        this.cardID = cardID;
    }
    
    public Identification getCardID(){
        return cardID;
    }
    
    public abstract String identify();
    
    public abstract int getCost();
    
    public abstract PlayerCard createCard();

    public String getTitle() {
        return title;
    }
}
