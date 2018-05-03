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
    CommitCharacterAction commitAction;
    
    public CharacterCard(){}
    
    public CharacterCard(LocationOnBoard cardLocation, int ownerID, int controllerID){
        super(cardLocation, ownerID, controllerID);
    }
    
    @Override
    public void instantiateActions(){
        super.instantiateActions();
        commitAction = new CommitCharacterAction(this);
    }
    
    @Override
    public abstract CharacterCardModel getCardModel();
    
    @Override
    public void getActions(ArrayList <Action> listOfActions, Board boardState, int askingID){
        commitAction.updateActionState(askingID, boardState);
        if(commitAction.isAvailable()){
            listOfActions.add(commitAction);
        }
    }
    
}
