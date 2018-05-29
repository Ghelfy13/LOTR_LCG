//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import lordoftherings.cardmodel.PlayerCardModel;
import java.util.ArrayList;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;
import lordoftherings.actions.EffectAction;
import lordoftherings.effects.Effect;

/**
 *
 * @author Amanda
 */
public abstract class PlayerCard{
    static final int ID_UNSET = -1;
    private LocationOnBoard cardLocation;
    private int ownerID;    
    private int controllerID;
    private ArrayList<EffectAction> effectActions;
    
    
    public PlayerCard(){
        cardLocation = LocationOnBoard.UNSET;
        ownerID = ID_UNSET;
        controllerID = ID_UNSET;
        effectActions = new ArrayList<>();
    }
    
    public PlayerCard(LocationOnBoard cardLocation, 
            int ownerID, 
            int controllerID){
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
        if(getCardModel().getListOfEffects() != null){
            ArrayList<Effect> effectList = getCardModel().getListOfEffects();
            for(int i = 0; i < effectList.size(); ++i){
                effectActions.add(effectList.get(i).getAction(this));
            }
        }
    }
    
    public void getActions(ArrayList <Action> listOfActions, Board boardState, int askingID){
        for(int i = 0; i < effectActions.size(); ++i){
            effectActions.get(i).updateActionState(askingID, boardState);
            if(effectActions.get(i).isAvailable()){
                listOfActions.add(effectActions.get(i));
            }
        }
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
