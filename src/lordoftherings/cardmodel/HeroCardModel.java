//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.cards.HeroCard;
import lordoftherings.game_engine.GameData.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.effects.Effect;

/**
 *
 * @author Amanda
 */
public class HeroCardModel extends CharacterCardModel{
     protected int threatCost;
     protected int resourcePool;
     
    public HeroCardModel(
        String title, 
        SphereOfInfluence sphereOfInfluence,
        PlayerCardType type, 
        String [] trait,
        Identification cardID,
        int willPower,
        int attack,
        int defense,
        int hitPoints,
        int threatCost, 
        int resourcePool,
        String effect,
        ArrayList<Effect> list,
        ArrayList<KeyWords> keyWords){
        super(
            title,
            sphereOfInfluence,
            type,
            trait,
            cardID,
            willPower,
            attack,
            defense,
            hitPoints,
            effect,
            list,
            true,
            keyWords);
         this.threatCost = threatCost;
         this.resourcePool = resourcePool;
     }
    
    public int getThreatCost(){
        return threatCost;
    }
     
    @Override
    public String identify(){
         String info = title.toUpperCase() + '\n'+'\n' +"Sphere: " + 
                 sphereOfInfluence + '\n' + "Type: " + type + '\n' + 
                 "WillPower: " + willPower + '\n' + "Attack Power: " + attack + 
                 '\n' + "Defense: " + defense + '\n' + "HitPoints: " + 
                 hitPoints + '\n' + "ThreatCost: " + threatCost + '\n' + '\n' + effect;
         return info;
     }
     
     @Override
     public int getCost(){
         return -1;
     }
     
     @Override
     public HeroCard createCard(){
         return HeroCard.get(this);
     }

    @Override
    public String getEffect() {
        return effect;
    }
    
}
