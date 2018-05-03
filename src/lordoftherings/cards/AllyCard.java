//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;
import lordoftherings.actions.Action;
import lordoftherings.actions.PlayAllyAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.AllyCardModel;

/**
 *
 * @author Amanda
 */
public class AllyCard extends CharacterCard{
    private AllyCardModel allyModel;
    private PlayAllyAction playAlly;
    
    private AllyCard(AllyCardModel allyModel){
        this.allyModel = allyModel;
    }
    
    private AllyCard(LocationOnBoard cardLocation, int ownerID, int controllerID, AllyCardModel allyModel){
        super(cardLocation, ownerID, controllerID);
        this.allyModel = allyModel;
    }
    
    public int getCost(){
        return allyModel.getCost();
    }
    
    public static AllyCard get(AllyCardModel model){
        AllyCard result = new AllyCard(model);
        result.instantiateActions();
        return result;
    }
    
    @Override
    public void instantiateActions(){
        super.instantiateActions();
        this.playAlly = new PlayAllyAction(this);
    }
    
    @Override
    public AllyCardModel getCardModel(){
        return allyModel;
    }
    
    @Override
    public void getActions(ArrayList <Action> listOfActions, Board boardState, int askingID){
        super.getActions(listOfActions, boardState, askingID);
        
        playAlly.updateActionState(askingID, boardState);
        if (playAlly.isAvailable()) {
            listOfActions.add(playAlly);
        }
    }

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.ALLY;
    }
}
