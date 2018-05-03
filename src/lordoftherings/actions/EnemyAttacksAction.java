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
public class EnemyAttacksAction extends Action{
    
    private EnemyCard card;
    
    public EnemyAttacksAction(EnemyCard enemy){
        super(getDescription(enemy));
        this.card = enemy;
    }
    
    private static String getDescription(EnemyCard enemy){
        return enemy.getTitle() + " is attacking";
    }

    @Override
    public boolean execute(int askingID, Board boardState) {
        Enemy aggitatedEnemy = boardState.getPlayerZoneAt(boardState.getCurrentPlayerNum()).getEngagementArea().findEnemyByCard(card);
        boardState.startAttackWithEnemy(aggitatedEnemy);
        return true;
    }

    @Override
    public void updateActionState(int askingID, Board boardState) {
        Enemy aggitatedEnemy = boardState.getPlayerZoneAt(boardState.getCurrentPlayerNum()).getEngagementArea().findEnemyByCard(card);
        if(aggitatedEnemy == null){
            state = ActionState.NOTAVAILABLE;
            return;
        }
        if(askingID == boardState.getCurrentPlayerNum() && boardState.getCurrentPhase() == GamePhase.COMBAT
                && boardState.getCurrentSubPhase() == CombatSubPhase.RESOLVE_ENEMY_ATTACKS && aggitatedEnemy.getLocationOnBoard() == LocationOnBoard.FIELD){
            if(aggitatedEnemy.isEnemyStillAttacking()){
                state = ActionState.EXECUTABLE;
            }else{
                state = ActionState.VISIBLE;
            }
        }else{
            state = ActionState.NOTAVAILABLE;
        }
    }
    
}
