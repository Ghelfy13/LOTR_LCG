//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.DeckComponents.SphereOfInfluence;


/**
 *
 * @author Amanda
 */
public abstract class AttachmentCardModel extends PlayerCardModel {
    protected int cost;
    
    public AttachmentCardModel(
        String title,
        SphereOfInfluence sphere,
        PlayerCardType type,
        String [] trait,
        Identification cardID,
        int cost){
        super(title, sphere, type, trait, cardID);
        this.cost = cost;
    }
    
    @Override
    public String identify(){
         String info = title + '\n' +"Sphere of Influence: " + sphereOfInfluence + '\n' + "Type: " + type + '\n' + "Cost: " + cost;
         return info;
     }
    
    @Override
    public int getCost(){
        return cost;
    }
    
}
