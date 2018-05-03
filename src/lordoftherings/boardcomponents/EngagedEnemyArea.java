//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.cards.EnemyCard;
import lordoftherings.characters.Enemy;
/**
 *
 * @author Amanda
 */
public class EngagedEnemyArea {//Belongs in Field
    private ArrayList<Enemy> listOfEngagedEnemies;
    private int controllerID;
    private PlayerZone playerZone;
    
    public EngagedEnemyArea(int controllerID, PlayerZone zone){
        this.listOfEngagedEnemies = new ArrayList<>(5);
        this.controllerID = controllerID;
        this.playerZone = zone;
    }
    
    public void addEnemy(Enemy newEnemy){
        listOfEngagedEnemies.add(newEnemy);
        newEnemy.getCard().setLocation(LocationOnBoard.FIELD, controllerID);
    }
    
    public Enemy removeEnemy(Enemy myEnemy){
        listOfEngagedEnemies.remove(myEnemy);
        return myEnemy;
    }
    
    public Enemy removeEnemyAt(int index){
        Enemy myEnemy = listOfEngagedEnemies.get(index);
        listOfEngagedEnemies.remove(index);
        return myEnemy;
    }
    
    public Enemy peek(int index){
        return listOfEngagedEnemies.get(index);
    }
    
    public void dealDamageWithDefenseToEnemyAt(int indexOfEnemy, int damage){
        int damageTaken = damage - listOfEngagedEnemies.get(indexOfEnemy).getDefense();
        if(damageTaken > 0){
            listOfEngagedEnemies.get(indexOfEnemy).assignDamage(damageTaken);
        }
    }
    
    public void moveDeadEnemiesToDiscardPile(){
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            Enemy current = listOfEngagedEnemies.get(i);
            if(current.getDamage() >= current.getMaxHealth()){
                removeEnemy(current);
                playerZone.getEnemyDiscardPile().addCardToPile(current.getCard());
            }
        }
    }
    
    public int getSize(){
        return listOfEngagedEnemies.size();
    }
    
    public ArrayList<Enemy> getListOfEnemies(){
        return listOfEngagedEnemies;
    }
    
    public String getInfo(int indexOfEnemy){
        return listOfEngagedEnemies.get(indexOfEnemy).getCard().identify();
    }
    
    public boolean isInEngagementArea(Enemy wantedEnemy){
        return listOfEngagedEnemies.contains(wantedEnemy);
    }

    public Enemy findEnemyByCard(EnemyCard card){//Can return null
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            if(listOfEngagedEnemies.get(i).getCard() == card){
                return listOfEngagedEnemies.get(i);
            }
        }
        return null;
    }
    
    public boolean enemiesStillAttacking(){
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            if(listOfEngagedEnemies.get(i).isEnemyStillAttacking()){
                return true;
            }
        }
        return false;
    }
    
    public void setEnemiesToAttacking(){
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            listOfEngagedEnemies.get(i).setEnemyToAttacking();
        }
    }
    
    public void setEnemiesToDefending(){
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            listOfEngagedEnemies.get(i).setEnemyToNotAttacking();
            listOfEngagedEnemies.get(i).setAttackedStatus(false);
        }
    }

    public boolean enemiesStillDefending() {
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            if(!listOfEngagedEnemies.get(i).hasBeenAttacked()){
                return true;
            }
        }
        return false;
    }

    void resetFightingStatus() {
        for(int i = 0; i < listOfEngagedEnemies.size(); ++i){
            listOfEngagedEnemies.get(i).setEnemyToNotAttacking();
            listOfEngagedEnemies.get(i).setAttackedStatus(true);
        }
    }
}
