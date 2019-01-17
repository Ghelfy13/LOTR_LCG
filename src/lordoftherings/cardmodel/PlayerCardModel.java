//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.game_engine.GameData.Identification;
import lordoftherings.cards.PlayerCard;
import lordoftherings.PlayerCardType;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.effects.Effect;

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
    protected String effect;
    protected ArrayList<Effect> listOfEffects;
    protected boolean isUnique;
    
    protected PlayerCardModel(
        String title, 
        SphereOfInfluence sphereOfInfluence,
        PlayerCardType type, 
        String [] trait, 
        Identification cardID,
        String effect,
        ArrayList<Effect> list,
        boolean isUnique){
        this.title = title;
        this.sphereOfInfluence = sphereOfInfluence;
        this.type = type;
        this.trait = trait;
        this.cardID = cardID;
        this.effect = effect;
        this.listOfEffects = list;
        this.isUnique = isUnique;
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
    
    public boolean isUnique(){
        return isUnique;
    }
    
    public abstract String getEffect();
    
    public ArrayList<Effect> getListOfEffects(){
        return listOfEffects;
    }
}
