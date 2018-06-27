//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.deckcomponents;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import lordoftherings.EnemyCardIdentificationComparator;
import lordoftherings.cardmodel.EncounterCardModel;

/**
 *
 * @author Amanda
 */
public class EncounterDeckBuild {
    private TreeMap<EncounterCardModel, Integer> enemyDeck;
    private int deckSize;
    
    public EncounterDeckBuild(){
        enemyDeck = new TreeMap(new EnemyCardIdentificationComparator());
    }

    public Iterator<Map.Entry<EncounterCardModel, Integer>> iterator() {
        return enemyDeck.entrySet().iterator();
    }
    
}
