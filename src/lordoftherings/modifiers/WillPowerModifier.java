//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.modifiers;

/**
 *
 * @author Amanda
 */
public class WillPowerModifier {
    private int numOfAdjustment;
    private LifeSpanOfModifier lifeSpan;
    
    public WillPowerModifier(int num, LifeSpanOfModifier span){
        numOfAdjustment = num;
        lifeSpan = span;
    }
    
    public int getNumOfAdjustment(){
        return numOfAdjustment;
    }
    
    public LifeSpanOfModifier getLifeSpan(){
        return lifeSpan;
    }
}
