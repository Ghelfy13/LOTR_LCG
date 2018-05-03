//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import lordoftherings.cardmodel.PlayerCardModel;
import java.util.ArrayList;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;

/**
 *
 * @author Amanda
 */
public abstract class PlayerCard{
    static final int ID_UNSET = -1;
    private LocationOnBoard cardLocation;
    private int ownerID;    
    private int controllerID;
    
    public PlayerCard(){
        cardLocation = LocationOnBoard.UNSET;
        ownerID = ID_UNSET;
        controllerID = ID_UNSET;
    }
    
    public PlayerCard(LocationOnBoard cardLocation, int ownerID, int controllerID){
        this.cardLocation = cardLocation;
        this.ownerID = ownerID;
        this.controllerID = controllerID;
    }
    
    public LocationOnBoard getLocation(){
        return cardLocation;
    }
    
    public int getOwner(){
        return ownerID;
    }
    
    public int getController(){
        return controllerID;
    }
    
    public String getTitle(){
        return getCardModel().getTitle();
    }
    
    public void setLocation(int newControllerID, LocationOnBoard newLocation){
        cardLocation = newLocation;
        controllerID = newControllerID;
    }
    
    public void setController(int newControllerID){
        controllerID = newControllerID;
    }
    public int getCost(){
        return getCardModel().getCost();
    }
    public String getIdentity(){
        return getCardModel().identify();
    }
    
    public void instantiateActions(){
        
    }
    
    public void getActions(ArrayList <Action> listOfActions, Board boardState, int askingID){
        return;
    }
    
    public abstract PlayerCardModel getCardModel();
    
    public abstract PlayerCardType getCardType();

    public void unsetLocation() {
        cardLocation = LocationOnBoard.UNSET;
        controllerID = ID_UNSET;
    }

    public void setOwner(int ownerID) {
        this.ownerID = ownerID;
    }
}
