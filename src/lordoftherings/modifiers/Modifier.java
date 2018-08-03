//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.modifiers;

/**
 *
 * @author Amanda
 */
public class Modifier {
    private LifeSpanOfModifier lifeSpan;
    private TypeOfModifier type;
    private int numOfAdjustment;
    
    public Modifier(int numOfAdjustment, TypeOfModifier type, LifeSpanOfModifier lifeSpan){
        this.type = type;
        this.lifeSpan = lifeSpan;
        this.numOfAdjustment = numOfAdjustment;
    }
    
    public LifeSpanOfModifier getLifeSpan(){
        return lifeSpan;
    }
    
    public TypeOfModifier getType(){
        return type;
    }
    
    public int getNumOfAdjustment(){
        return numOfAdjustment;
    }
}
