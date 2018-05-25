//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.DeckComponents.SphereOfInfluence;

/**
 *
 * @author Amanda
 */
public abstract class EventCardModel extends PlayerCardModel{
    protected int cost;
    
    public EventCardModel(
    String title,
    SphereOfInfluence sphere,
    PlayerCardType type,
    String [] trait,
    Identification cardID,
    int cost,
    String effect){
        super(title, sphere, type, trait, cardID, effect);
        this.cost = cost;
    }
    
    @Override
    public String identify(){
         String info = title + '\n' +"Sphere of Influence: " + sphereOfInfluence + 
                 '\n' + "Type: " + type + '\n' + "Cost: " + cost + '\n' + '\n' + effect;
         return info;
    }
    
    @Override
    public int getCost(){
        return cost;
    }
}
