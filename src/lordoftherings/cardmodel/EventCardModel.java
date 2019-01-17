//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.game_engine.GameData.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.cards.EventCard;
import lordoftherings.cards.PlayerCard;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.effects.Effect;

/**
 *
 * @author Amanda
 */
public class EventCardModel extends PlayerCardModel{
    protected int cost;
    
    public EventCardModel(
    String title,
    SphereOfInfluence sphere,
    PlayerCardType type,
    String [] trait,
    Identification cardID,
    int cost,
    String effect,
    ArrayList<Effect> list){
        super(title, sphere, type, trait, cardID, effect, list, false);
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

    @Override
    public EventCard createCard() {
        return EventCard.get(this);
    }

    @Override
    public String getEffect() {
        return effect;
    }
}
