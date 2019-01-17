//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

import lordoftherings.game_engine.GameData.Identification;
import java.util.Comparator;
import lordoftherings.cardmodel.EnemyCardModel;

/**
 *
 * @author Amanda
 */
public class EnemyCardIdentificationComparator 
        implements Comparator<EnemyCardModel>{

    @Override
    public int compare(EnemyCardModel card1, EnemyCardModel card2) {
        Identification card1ID = card1.getCardID();
        Identification card2ID = card2.getCardID();
        return card1ID.compareTo(card2ID);
    }
    
}
