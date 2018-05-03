//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;
import lordoftherings.cardmodel.PlayerCardModel;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import lordoftherings.PlayerCardIdentificationComparator;

/**
 *
 * @author Amanda
 */
public class DeckBuild {
    private TreeMap<PlayerCardModel, Integer> deckToBeBuilt;
    private int deckSize;
    
    public DeckBuild(){
        deckToBeBuilt = new TreeMap(new PlayerCardIdentificationComparator());
        deckSize = 0;
    }
    
    public void add(PlayerCardModel newCard, int numberOfCard){
        if(!deckToBeBuilt.containsKey(newCard)){
            deckToBeBuilt.put(newCard, numberOfCard);
        }else{
            deckToBeBuilt.put(newCard, deckToBeBuilt.get(newCard) + numberOfCard);
        }
        deckSize += numberOfCard;
    }
    
    public boolean removeModelAmount(PlayerCardModel wantedModel, int amount){
        Integer numOfModel = deckToBeBuilt.get(wantedModel);
        if(numOfModel == null){
            return true;
        }else if(numOfModel.intValue() < amount){
            removeAllOfModel(wantedModel);
            return false;
        }else{
            deckToBeBuilt.put(wantedModel, numOfModel.intValue() -amount);
            deckSize -= amount;
            return true;
        }
    }
    
    public void removeAllOfModel(PlayerCardModel wantedModel){
        deckSize -= deckToBeBuilt.get(wantedModel);
        deckToBeBuilt.remove(wantedModel);
    }
    
    public Iterator<Map.Entry<PlayerCardModel, Integer>> iterator(){
        return deckToBeBuilt.entrySet().iterator();
    }
    
    public int getDeckSize(){
        return deckSize;
    }
    
    
}
