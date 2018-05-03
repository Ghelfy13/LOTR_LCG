//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.cards.CharacterCard;
import lordoftherings.Identification;
import lordoftherings.PlayerCardType;
import lordoftherings.DeckComponents.SphereOfInfluence;

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
        int hitPoints){
        super(title, sphereOfInfluence, type, trait, cardID);
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
}
