//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.effects.Effect;


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
        int cost,
        String effect,
        ArrayList<Effect> list){
        super(title, sphere, type, trait, cardID, effect, list);
        this.cost = cost;
    }
    
    @Override
    public String identify(){
         String info = title + '\n' +"Sphere of Influence: " + sphereOfInfluence + 
                 '\n' + "Type: " + type + '\n' + "Cost: " + cost + '\n' + '\n' +
                 effect;
         return info;
     }
    
    @Override
    public int getCost(){
        return cost;
    }
    
    @Override
    public String getEffect(){
        return effect;
    }
    
}
