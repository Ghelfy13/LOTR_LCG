//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import java.util.ArrayList;
import lordoftherings.cards.CharacterCard;
import lordoftherings.modifiers.WillPowerModifier;

/**
 *
 * @author Amanda
 */
public abstract class GameCharacter {
    protected int damage;
    private boolean isExhausted;
    private boolean isCommitted;
    private ArrayList<WillPowerModifier> willPowerModifiers;
    
    public GameCharacter(){
        damage = 0;
        isExhausted = false;
        isCommitted = false;
        willPowerModifiers = new ArrayList<>();
    }
    
    abstract public CharacterCard getCard();
    
    public void addWillPowerMod(WillPowerModifier mod){
        willPowerModifiers.add(mod);
    }
    
     public boolean removeWillPowerMod(WillPowerModifier mod){
        return willPowerModifiers.remove(mod);
    }
    
    public ArrayList<WillPowerModifier> getWillPowerMods(){
        return willPowerModifiers;
    }
    
    public int getWillPowerWithMods(){
        int num = getCard().getCardModel().getWillPower();
        for(int i = 0; i < willPowerModifiers.size(); ++i){
            num += willPowerModifiers.get(i).getNumOfAdjustment();
        }
        return num;
    }
    
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
        return getWillPowerWithMods();
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
