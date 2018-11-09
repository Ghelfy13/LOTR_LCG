//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;
import lordoftherings.actions.Action;
import lordoftherings.actions.EnemyAttacksAction;
import lordoftherings.actions.EngageEnemyAction;
import lordoftherings.actions.PlayerAttacksEnemy;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cardmodel.EnemyCardModel;

/**
 *
 * @author Amanda
 */
public class EnemyCard extends EncounterCard{

    private EnemyCardModel model;
    private EngageEnemyAction engageEnemy;
    private EnemyAttacksAction attackingEnemy;
    private PlayerAttacksEnemy enemyBeingAttacked;
    
    public EnemyCard(EnemyCardModel cardModel){
        this.model = cardModel;
        this.engageEnemy = new EngageEnemyAction(this);
        this.attackingEnemy = new EnemyAttacksAction(this);
        this.enemyBeingAttacked = new PlayerAttacksEnemy(this);
    }
    
    public EnemyCard(EnemyCardModel cardModel, int controllerID, LocationOnBoard cardLocation){
        super(cardLocation, controllerID);
        this.model = cardModel;
        this.engageEnemy = new EngageEnemyAction(this);
        this.attackingEnemy = new EnemyAttacksAction(this);
        this.enemyBeingAttacked = new PlayerAttacksEnemy(this);
    }
    
    public int getThreat(){
        return model.getThreat();
    }
    
    public int getAttack(){
        return model.getAttack();
    }
    
    public int getHitPoints(){
        return model.getHitPoints();
    }
    
    public int getDefense(){
        return model.getDefense();
    }
    
    public String[] getTraits(){
        return model.getTraits();
    }
    
    public String identify(){
        return model.identify();
    }
    
    public int getEngagementCost(){
        return model.getEngagementCost();
    }
    
    public String getTitle(){
        return model.getTitle();
    }
    @Override
    public EncounterCardModel getModel() {
        return model;
    }

    @Override
    public void afterOnWhenRevealed(Board board) {
        board.addEnemyToStagingArea(this);
    }
    
    /**
     *
     * @param listOfActions
     * @param board
     * @param askingID
     */
    @Override
    public void getActions(ArrayList<Action> listOfActions, Board board, int askingID){
        super.getActions(listOfActions, board, askingID);
        engageEnemy.updateActionState(askingID, board);
        attackingEnemy.updateActionState(askingID, board);
        enemyBeingAttacked.updateActionState(askingID, board);
        if(engageEnemy.isAvailable()){
            listOfActions.add(engageEnemy);
        }
        if(attackingEnemy.isAvailable()){
            listOfActions.add(attackingEnemy);
        }
        if(enemyBeingAttacked.isAvailable()){
            listOfActions.add(enemyBeingAttacked);
        }
    }

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.ENEMY;
    }

    @Override
    public int getVictoryPoints() {
        return model.getVictoryPoints();
    }
    
}
