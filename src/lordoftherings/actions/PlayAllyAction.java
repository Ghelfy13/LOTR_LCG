//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.AllyCard;
import lordoftherings.cards.PlayerCard;
import java.util.ArrayList;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.characters.Hero;
import lordoftherings.LocationOnBoard;
import lordoftherings.phasemanager.PlanningSubPhase;

/**
 *
 * @author Amanda
 */
public class PlayAllyAction extends Action{
    private AllyCard cardToPlay;
    
    public PlayAllyAction(AllyCard cardToPlay){
        super(getDescription(cardToPlay));
        this.cardToPlay = cardToPlay;
    }
    
    private static String getDescription(PlayerCard card){
        return "Play " + card.getTitle();
    }
    
    @Override
    public boolean execute(int askingID, Board boardState){
        PlayerZone playerArea = boardState.getPlayerZoneAt(cardToPlay.getController());
        int totalResources = playerArea.getHerosResources();
        if(totalResources>= cardToPlay.getCost()){
            boolean result = playerArea.moveAllyFromHandToField(cardToPlay);
            payForAlly(playerArea);
            return result;
        }else{
            return false;
        }
    }
    
    @Override
    public void updateActionState(int askingID, Board boardState){
        PlayerZone playerArea = boardState.getPlayerZoneAt(cardToPlay.getController());
        boolean isUnique = cardToPlay.getCardModel().isUnique();
        if(cardToPlay.getLocation() == LocationOnBoard.HAND &&
            askingID == cardToPlay.getController() &&
            boardState.getPhaseManagerGovenor().getCurrentPhase() == GamePhase.PLANNING && 
            boardState.getPhaseManagerGovenor().getCurrentSubPhase() == 
                 PlanningSubPhase.PLAY_ALLIES_AND_ATTACHMENTS &&
            boardState.isCurrentPlayer(askingID)){
            if(isUnique){
                if(boardState.alreadyHasUniqueCardInPlay(cardToPlay)){
                    state = ActionState.VISIBLE;
                    return;
                }else{
                    if(playerArea.getField().canAfford(cardToPlay)){
                        state = ActionState.EXECUTABLE;
                    }
                    else{
                       state = ActionState.VISIBLE;
                    }
                }
            }else{
                if(playerArea.getField().canAfford(cardToPlay)){
                    state = ActionState.EXECUTABLE;
                }else{
                    state = ActionState.VISIBLE;
                }
            }
        }
        else{
            state = ActionState.NOTAVAILABLE;
        }
    }
    
    public void payForAlly(PlayerZone currentZone){
        int cost = cardToPlay.getCost();
        ArrayList<Hero> myHeros = currentZone.getHeros();
        for(int i = 0; i < myHeros.size(); ++i){
            int debt = myHeros.get(i).spendResources(cost);
            if(debt == 0){
                return;                
            }else{
                cost = debt;
            }
            
        }
    }
}
