//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import java.util.ArrayList;
import lordoftherings.cards.CharacterCard;
import lordoftherings.modifiers.Modifier;
import lordoftherings.modifiers.TypeOfModifier;

/**
 *
 * @author Amanda
 */
public abstract class GameCharacter {
    protected int damage;
    private boolean isExhausted;
    private boolean isCommitted;
    private ArrayList<Modifier> modifiers;
    
    public GameCharacter(){
        damage = 0;
        isExhausted = false;
        isCommitted = false;
        modifiers = new ArrayList<>();
    }
    
    abstract public CharacterCard getCard();
    
    public void addModifier(Modifier mod){
        modifiers.add(mod);
    }
    
     public boolean removeModifier(Modifier mod){
        return modifiers.remove(mod);
    }
    
    public ArrayList<Modifier> getModifiers(){
        return modifiers;
    }
    
    public int getWillPowerWithMods(){
        ArrayList<Modifier> willMods = new ArrayList<>();
        for(int i = 0; i < modifiers.size(); ++i){
            if(modifiers.get(i).getType() == TypeOfModifier.WILL_POWER){
                willMods.add(modifiers.get(i));
            }
        }
        int num = getWillPower();
        for(int j = 0; j < willMods.size(); ++j){
            num += willMods.get(j).getNumOfAdjustment();
        }
        return num;
    }
    
    public int getAttackWithMods(){
        ArrayList<Modifier> attackMods = new ArrayList<>();
        for(int i = 0; i < modifiers.size(); ++i){
            if(modifiers.get(i).getType() == TypeOfModifier.ATTACK){
                attackMods.add(modifiers.get(i));
            }
        }
        int num = getAttack();
        for(int j = 0; j < attackMods.size(); ++j){
            num += attackMods.get(j).getNumOfAdjustment();
        }
        return num;
    }
    
    public int getDefenseWithMods(){
        ArrayList<Modifier> defenseMods = new ArrayList<>();
        for(int i = 0; i < modifiers.size(); ++i){
            if(modifiers.get(i).getType() == TypeOfModifier.DEFENSE){
                defenseMods.add(modifiers.get(i));
            }
        }
        int num = getDefense();
        for(int j = 0; j < defenseMods.size(); ++j){
            num += defenseMods.get(j).getNumOfAdjustment();
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
