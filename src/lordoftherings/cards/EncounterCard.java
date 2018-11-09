//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EncounterCardModel;

/**
 *
 * @author Amanda
 */
public abstract class EncounterCard {
    
    private LocationOnBoard cardLocation;
    public static final int UNSET_ID = -5;
    private int ownerID;    
    private int controllerID;
    
    public EncounterCard(){
        cardLocation = LocationOnBoard.UNSET;
        controllerID = -5;
        ownerID = UNSET_ID;
    }
    
    public EncounterCard(LocationOnBoard cardLocation, int controllerID){
        this.ownerID = UNSET_ID;
        this.cardLocation = cardLocation;
        this.controllerID = controllerID;
    }
    
    public LocationOnBoard getLocation(){
        return cardLocation;
    }
    
    public int getOwnerID(){
        return ownerID;
    }
    
    public int getControllerID(){
        return controllerID;
    }
    
    public void setLocation(LocationOnBoard newLocation, int newControllerID){
        this.cardLocation = newLocation;
        this.controllerID = newControllerID;
    }
    
    public void setController(int newMaster){
        this.controllerID = newMaster;
    }
    
    public String getIdentity(){
        return getModel().identify();
    }
    
    abstract public EncounterCardModel getModel();
    
    abstract public PlayerCardType getCardType();
    
    abstract public int getVictoryPoints();
    
    abstract public void afterOnWhenRevealed(Board board);
    
    public void getActions(ArrayList<Action> listOfActions, Board board, int askingID){
        return;
    }
}
