//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.game_engine.GameData;
import lordoftherings.deckcomponents.ExpansionName;
/**
 *
 * @author Amanda
 */
public class Identification implements Comparable<Identification> {
    protected ExpansionName setName;
    protected int numInSet;
    
    public Identification(ExpansionName setName, int numInSet){
        this.setName = setName;
        this.numInSet = numInSet;
    }

    @Override
    public int compareTo(Identification other) {
        if(this.numInSet == other.numInSet && this.setName == other.setName){
            return 0;
        }else if(this.setName != other.setName){
            return Integer.compare(this.setName.ordinal(), other.setName.ordinal());
        }else{
            return Integer.compare(this.numInSet, other.numInSet);
        }
    }
    
    @Override
    public int hashCode() {
        return setName.ordinal()*161 + numInSet;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Identification)) {
            return false;
        }
        Identification otherID = (Identification) other;
        return otherID.setName == setName &&
                otherID.numInSet == numInSet;
    }
}
