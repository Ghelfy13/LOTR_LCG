//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.characters.Enemy;

/**
 *
 * @author Amanda
 */
public class DefaultEnemyQueryHandler implements EnemyQueryHandler{

    private Board board;
    
    public DefaultEnemyQueryHandler(Board board){
        this.board = board;
    }
    
    @Override
    public void handleQuery(EnemyQueryHandle handle, String descriptionOfAction) {
        ArrayList<Enemy> listOfEnemies = new ArrayList<>();
        if(handle.getMin() == 0){
            handle.getResultHandler().handle(listOfEnemies);
        }
        else{
            for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                EngagedEnemyArea engagedZone = board.getPlayerZoneAt(i).getEngagementArea();
                if(listOfEnemies.size() == handle.getMin()){
                    break;
                }
                ArrayList<Enemy> currentList = engagedZone.getListOfEnemies();
                for(int j = 0; j < currentList.size(); ++j){
                    
                    if(handle.getMatcher().matches(currentList.get(j))){
                        listOfEnemies.add(currentList.get(j));
                    }
                }
            }
        }
        if(listOfEnemies.size() == handle.getMin()){
            handle.getResultHandler().handle(listOfEnemies);
        }else{
            handle.getCancelHandler().cancel();
        }
    }
    
}
