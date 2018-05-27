//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.Action;
import lordoftherings.actions.CommitCharacterAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.CharacterCardModel;

/**
 *
 * @author Amanda
 */
public abstract class CharacterCard extends PlayerCard{
    private CommitCharacterAction commitAction;
    private CharacterCardModel model;
    
    public CharacterCard(CharacterCardModel model){
        super(model);
    }
    
    public CharacterCard(LocationOnBoard cardLocation, 
            int ownerID, 
            int controllerID,
            CharacterCardModel model){
        super(cardLocation, ownerID, controllerID, model);
    }
    
    public void instantiateActions(){
        super.instantiateActions();
        commitAction = new CommitCharacterAction(this);
    }
    
    @Override
    public CharacterCardModel getCardModel(){
        return model;
    }
    
    @Override
    public void getActions(ArrayList <Action> listOfActions, Board boardState, int askingID){
        commitAction.updateActionState(askingID, boardState);
        if(commitAction.isAvailable()){
            listOfActions.add(commitAction);
        }
    }
    
}
