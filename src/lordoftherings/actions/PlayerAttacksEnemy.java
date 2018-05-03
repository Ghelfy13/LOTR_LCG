//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.LocationOnBoard;
import lordoftherings.PhaseManager.CombatSubPhase;
import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class PlayerAttacksEnemy extends Action{
    private EnemyCard targetedEnemy;

    public PlayerAttacksEnemy(EnemyCard target) {
        super(getDescription(target));
        this.targetedEnemy = target;
    }
    
    public static String getDescription(EnemyCard enemy){
        return "Currently attacking enemy " + enemy.getTitle();
    }

    @Override
    public boolean execute(int askingID, Board boardState) {
        Enemy target = boardState.getPlayerZoneAt(boardState.getCurrentPlayerNum()).getEngagementArea().findEnemyByCard(targetedEnemy);
        boardState.startPlayerAttackOnEnemy(target);
        return true;
    }

    @Override
    public void updateActionState(int askingID, Board boardState) {
        Enemy target = boardState.getPlayerZoneAt(boardState.getCurrentPlayerNum()).getEngagementArea().findEnemyByCard(targetedEnemy);
        if(target == null){
            state = ActionState.NOTAVAILABLE;
            return;
        }
        if(target.hasBeenAttacked()){
            state = ActionState.NOTAVAILABLE;
            return;
        }
        if(askingID == boardState.getCurrentPlayerNum() && boardState.getCurrentPhase() == GamePhase.COMBAT
                && boardState.getCurrentSubPhase() == CombatSubPhase.RESOLVE_PLAYER_ATTACKS && target.getLocationOnBoard() == LocationOnBoard.FIELD){
            if(!target.hasBeenAttacked()){
                state = ActionState.EXECUTABLE;
            }else{
                state = ActionState.VISIBLE;
            }
        }else{
            state = ActionState.NOTAVAILABLE;
        }
    }
    
}
