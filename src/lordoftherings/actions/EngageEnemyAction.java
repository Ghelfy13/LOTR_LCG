//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.LocationOnBoard;
import lordoftherings.phasemanager.EncounterSubPhase;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class EngageEnemyAction extends Action{
    private EnemyCard desiredCard;
    
    public EngageEnemyAction(EnemyCard desiredCard){
        super(getDescription(desiredCard));
        this.desiredCard = desiredCard;
    }
    
    private static String getDescription(EnemyCard desiredEnemy){
        return "Engage " +desiredEnemy.getTitle();
    }

    @Override
    public boolean execute(int askingID, Board boardState) {
        PlayerZone playerZone = boardState.getPlayerZoneAt(boardState.getCurrentPlayerNum());
        EngagedEnemyArea area = playerZone.getEngagementArea();
        Enemy wantedEnemy = boardState.getEncounterZone().getStagingArea().getEnemyFromCard(desiredCard);
        if(wantedEnemy != null && !playerZone.hasEngagedEnemy()){
            area.addEnemy(wantedEnemy);
            boardState.getEncounterZone().getStagingArea().removeEnemy(wantedEnemy);
            playerZone.setEngagedEnemyYet(true);
            return true;
        }
        return false;
    }

    @Override
    public void updateActionState(int askingID, Board boardState) {
        if(askingID == boardState.getCurrentPlayerNum() && desiredCard.getLocation() == LocationOnBoard.ENCOUNTER_ZONE
                && boardState.getPhaseManagerGovenor().getCurrentPhase() == GamePhase.ENCOUNTER &&
                boardState.getPhaseManagerGovenor().getCurrentSubPhase() == EncounterSubPhase.ENGAGE_ENEMY){
            PlayerZone zone = boardState.getPlayerZoneAt(boardState.getCurrentPlayerNum());
            if(!zone.hasEngagedEnemy()){
                state = ActionState.EXECUTABLE;
            }else{
                state = ActionState.VISIBLE;
            }
            
        }else{
            state = ActionState.NOTAVAILABLE;
        }
    }
}
