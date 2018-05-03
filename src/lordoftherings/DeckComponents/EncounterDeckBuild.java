//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import lordoftherings.EnemyCardIdentificationComparator;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cardmodel.EnemyCardModel;

/**
 *
 * @author Amanda
 */
public class EncounterDeckBuild {
    private TreeMap<EncounterCardModel, Integer> enemyDeck;
    private ArrayList<EncounterSetBuild> setBuild;
    private int deckSize;
    
    public EncounterDeckBuild(){
        enemyDeck = new TreeMap(new EnemyCardIdentificationComparator());
    }

    public Iterator<Map.Entry<EncounterCardModel, Integer>> iterator() {
        return enemyDeck.entrySet().iterator();
    }
}
