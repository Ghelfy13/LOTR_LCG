//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.cards.CharacterCard;
import lordoftherings.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.deckcomponents.SphereOfInfluence;
import lordoftherings.effects.Effect;

/**
 *
 * @author Amanda
 */
public abstract class CharacterCardModel extends PlayerCardModel{
    protected int willPower;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    
    public CharacterCardModel(
        String title, 
        SphereOfInfluence sphereOfInfluence,
        PlayerCardType type, 
        String [] trait,
        Identification cardID,
        int willPower,
        int attack,
        int defense,
        int hitPoints,
        String effect,
        ArrayList<Effect> list,
        boolean isUnique){
        super(title, sphereOfInfluence, type, trait, cardID, effect, list, isUnique);
        this.willPower = willPower;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }
    
    public int getWillPower(){
        return willPower;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public int getHitPoints(){
        return hitPoints;
    }
    
    @Override
    public abstract CharacterCard createCard();
    
    @Override
    public abstract String getEffect();
}
