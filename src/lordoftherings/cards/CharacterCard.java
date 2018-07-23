//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.Action;
import lordoftherings.actions.CommitCharacterAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.CharacterCardModel;
import lordoftherings.modifiers.WillPowerModifier;

/**
 *
 * @author Amanda
 */
public abstract class CharacterCard extends PlayerCard{
    private CommitCharacterAction commitAction;
    private ArrayList<WillPowerModifier> willPowerModifiers;
    
    public CharacterCard(){
    }
    
    public CharacterCard(LocationOnBoard cardLocation, 
            int ownerID, 
            int controllerID){
        super(cardLocation, ownerID, controllerID);
        willPowerModifiers = new ArrayList<>();
    }
    
    public void instantiateActions(){
        super.instantiateActions();
        commitAction = new CommitCharacterAction(this);
    }
    
    public void addWillPowerMod(WillPowerModifier mod){
        willPowerModifiers.add(mod);
    }
    
    public boolean removeWillPowerMod(WillPowerModifier mod){
        return willPowerModifiers.remove(mod);
    }
    
    public ArrayList<WillPowerModifier> getWillPowerMods(){
        return willPowerModifiers;
    }
    
    public int getWillPowerWithMods(){
        int num = getCardModel().getWillPower();
        for(int i = 0; i < willPowerModifiers.size(); ++i){
            num += willPowerModifiers.get(i).getNumOfAdjustment();
        }
        return num;
    }
    
    @Override
    public abstract CharacterCardModel getCardModel();
    
    @Override
    public void getActions(ArrayList <Action> listOfActions, Board boardState, int askingID){
        super.getActions(listOfActions, boardState, askingID);
        commitAction.updateActionState(askingID, boardState);
        if(commitAction.isAvailable()){
            listOfActions.add(commitAction);
        }
    }
    
}
