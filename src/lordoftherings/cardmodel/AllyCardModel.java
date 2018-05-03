//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.cards.AllyCard;
import lordoftherings.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.DeckComponents.SphereOfInfluence;

/**
 *
 * @author Amanda
 */
public class AllyCardModel extends CharacterCardModel {
    protected int cost;
    
    public AllyCardModel(
        String title, 
        SphereOfInfluence sphereOfInfluence,
        PlayerCardType type, 
        String [] trait,
        Identification cardID,
        int willPower,
        int attack,
        int defense,
        int hitPoints,
        int cost){
        super(
            title,
            sphereOfInfluence,
            type,
            trait,
            cardID,
            willPower,
            attack,
            defense,
            hitPoints);
        this.cost = cost;
    }
    
    @Override
    public String identify(){
         String info = title.toUpperCase() + '\n' + '\n'+ "Sphere: " + sphereOfInfluence + '\n' + "Type: " + type + '\n' + "WillPower: " + willPower + '\n' 
                 + "Attack Power: " + attack + '\n' + "Defense: " + defense + '\n' + "HitPoints: " + hitPoints + '\n';
         return info;
     }
    
    @Override
    public int getCost(){
        return cost;
    }
    
    @Override
    public AllyCard createCard(){
        return AllyCard.get(this);
    }
   
}
