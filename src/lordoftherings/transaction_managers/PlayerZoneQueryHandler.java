//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;

/**
 *
 * @author Amanda
 */
public class PlayerZoneQueryHandler {
    
    private Board board;
    
    public PlayerZoneQueryHandler(Board board){
        this.board = board;
    }
    
    public void handleQuery(PlayerZoneQueryHandle handle, String descriptionOfQuery){
        int numOfPlayerZones = 0;
        ArrayList<PlayerZone> listOfZones = new ArrayList<>(handle.getMax());
        if(handle.getMin() == 0){
            handle.getResultHandler().handle(listOfZones);
        }
        else{
            for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                if(numOfPlayerZones == handle.getMin()){
                    break;
                }else{
                    if(handle.getMatcher().matches(board.getPlayerZoneAt(i))){
                        ++numOfPlayerZones;
                        listOfZones.add(board.getPlayerZoneAt(i));
                    }
                }
            }
        }
        if(numOfPlayerZones == handle.getMin()){
            handle.getResultHandler().handle(listOfZones);
        }else{
            handle.getCancelHandler().cancel();
        }
    }
}
