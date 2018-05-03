//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import lordoftherings.cardmodel.QuestCardModel;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;

/**
 *
 * @author Amanda
 */
public class QuestCard {
    private QuestCardModel questModel;
    private LocationOnBoard cardLocation;
    private int ownerID;
    
    public QuestCard(QuestCardModel questModel){
        this.questModel = questModel;
        this.cardLocation = LocationOnBoard.DECK;
        ownerID = -4;
    }
    
    public QuestCardModel getModel(){
        return questModel;
    }
    
    public void setLocation(LocationOnBoard newLocation){
        cardLocation = newLocation;
    }
    
    public LocationOnBoard getLocation(){
        return cardLocation;
    }
    
    public int getOwnerID(){
        return ownerID;
    }

    public PlayerCardType getCardType() {
        return PlayerCardType.QUEST;
    }

}
