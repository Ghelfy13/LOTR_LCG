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
public class EnemyArea {
    private ArrayList<Enemy> listOfEnemies;
    
    public EnemyArea(){
        listOfEnemies = new ArrayList<>();
    }
    
    public void addEnemyToList(Enemy newEnemy){
        listOfEnemies.add(newEnemy);
        newEnemy.getCard().setLocation(LocationOnBoard.ENCOUNTER_ZONE, EncounterZone.OWNER_ID);
    }
    
    public Enemy getEnemy(Enemy wantedEnemy){//Can return null
        if(listOfEnemies.contains(wantedEnemy)){
            return listOfEnemies.get(listOfEnemies.indexOf(wantedEnemy));
        }else{
            return null;
        }
    }
    
    public ArrayList<Enemy> getListOfEnemies(){
        return listOfEnemies;
    }
    
    public void removeEnemy(Enemy wantedEnemy){//can return null
        listOfEnemies.remove(wantedEnemy);
    }
    
    public boolean findCard(Enemy wantedEnemy){
        return listOfEnemies.contains(wantedEnemy);
    }
    
    public int findEnemyByCard(EnemyCard card){
        for(int i = 0; i < listOfEnemies.size(); ++i){
            if(listOfEnemies.get(i).getCard() == card){
                return i;
            }
        }
        return -1;
    }
    
    public Enemy getEnemyAt(int index){
        return listOfEnemies.get(index);
    }
    
    public void removeEnemyAt(int index){
        listOfEnemies.remove(index);
    }
    
    public void clearEnemyList(){
        listOfEnemies.clear();
    }
    
    public int getNumOfEnemies(){
        return listOfEnemies.size();
    }
}
