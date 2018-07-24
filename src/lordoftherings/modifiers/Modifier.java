//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.modifiers;

/**
 *
 * @author Amanda
 */
public class Modifier {
    private int numOfAdjustment;
    private TypeOfModifier type;
    private LifeSpanOfModifier lifeSpan;
    
    public Modifier(int num, TypeOfModifier type, LifeSpanOfModifier lifeSpan){
        this.numOfAdjustment = num;
        this.type = type;
        this.lifeSpan = lifeSpan;
    }
    
    public int getNumOfAdjustment(){
        return numOfAdjustment;
    }
    
    public TypeOfModifier getType(){
        return type;
    }
    
    public LifeSpanOfModifier getLifeSpan(){
        return lifeSpan;
    }
}
