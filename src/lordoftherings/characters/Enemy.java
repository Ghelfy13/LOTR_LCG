//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.characters;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cards.EnemyCard;

/**
 *
 * @author Amanda
 */
public class Enemy {
    private EnemyCard card;
    protected int damage;
    private boolean isAttacking;
    private boolean beenAttacked;
    private boolean canAttack;
    
    public Enemy(EnemyCard enemyCard){
        this.card = enemyCard;
        damage = 0;
        this.isAttacking = false;
        this.beenAttacked = true;
        this.canAttack = true;
    }
    
    public void assignDamage(int newDamage){
        damage += newDamage;
    }
    
    public int getMaxHealth(){
        return card.getHitPoints();
    }
    
    public int getHealth(){
        return getMaxHealth() - damage;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public int getAttack(){
        return card.getAttack();
    }
    
    public int getDefense(){
        return card.getDefense();
    }
    
    public boolean isEnemyStillAttacking(){
        return isAttacking;
    }
    
    public EnemyCard getCard(){
        return card;
    }
    
    public void setEnemyToAttacking(){
        isAttacking = true;
        canAttack = true;
    }
    
    public void setEnemyToNotAttacking(){
        isAttacking = false;
        canAttack = false;
    }
    
    public void enemyCanNotAttack(){
        canAttack = false;
    }
    
    public void enemyCanAttack(){
        canAttack = true;
    }
    
    public boolean canEnemyAttack(){
        return canAttack;
    }
    
    public void getActions(ArrayList<Action> listOfActions, Board board, int askingID){
        card.getActions(listOfActions, board, askingID);
    }

    public int getThreat() {
        return card.getThreat();
    }
    
    public LocationOnBoard getLocationOnBoard(){
        return card.getLocation();
    }
    
    public boolean hasBeenAttacked(){
        return beenAttacked;
    }
    
    public void setAttackedStatus(boolean attacked){
        beenAttacked = attacked;
    }
}
