//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import lordoftherings.cards.CharacterCard;

/**
 *
 * @author Amanda
 */
public abstract class GameCharacter {
    protected int damage;
    private boolean isExhausted;
    private boolean isCommitted;
    
    
    public GameCharacter(){
        damage = 0;
        isExhausted = false;
        isCommitted = false;
    }
    
    abstract public CharacterCard getCard();
    
    public int getAttack(){
        return getCard().getCardModel().getAttack();
    }
    
    public int getDefense(){
        return getCard().getCardModel().getDefense();
    }
    
    public int getMaxHealth(){
        return getCard().getCardModel().getHitPoints();
    }
    
    public int getWillPower(){
        return getCard().getCardModel().getWillPower();
    }
    
    public int getHealth(){
        return (getMaxHealth() - damage);
    }
    
    public void exhaust(){
        isExhausted = true;
    }
    
    public void unExhaust(){
        isExhausted = false;
    }
    
    public void commit(){
        isCommitted = true;
    }
    
    public void unCommit(){
        isCommitted = false;
    }
    
    public void ready(){
        isExhausted = false;
    }
    
    public boolean isExhausted(){
        return isExhausted;
    }
    
    public boolean isCommitted(){
        return isCommitted;
    }
    
    public void assignDamage(int amount){
        damage += amount;
    }
    
    public void removeDamage(int amount){
        if(amount >= damage){
            damage = 0;
        }else{
            damage -= amount;
        }
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void assignDamageWithDefense(int damageDealt){
        int receivedDamage = damageDealt - getDefense();
        if(receivedDamage > 0){
            damage += receivedDamage;
        }
    }
    
}
