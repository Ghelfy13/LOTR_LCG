//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings;

import lordoftherings.cardmodel.PlayerCardModel;
import java.util.Comparator;
/**
 *
 * @author Amanda
 */
public class PlayerCardIdentificationComparator
        implements Comparator<PlayerCardModel>{

    @Override
    public int compare(PlayerCardModel card1, PlayerCardModel card2) {
        Identification card1ID = card1.getCardID();
        Identification card2ID = card2.getCardID();
        return card1ID.compareTo(card2ID);
    }
    
    
}
