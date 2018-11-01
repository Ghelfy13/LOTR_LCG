//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import java.util.ArrayList;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.DiscardPile;

/**
 *
 * @author Amanda
 */
public class DefaultDiscardPileQueryHandler implements DiscardPileQueryHandler {
    
    private Board board;
    
    public DefaultDiscardPileQueryHandler(Board board){
        this.board = board;
    }

    @Override
    public void handleQuery(DiscardPileQueryHandle handle, String descriptionOfAction) {
        ArrayList<DiscardPile> listOfDPiles = new ArrayList<>();
        if(handle.getMin() == 0){
            handle.getResultHandler().handle(listOfDPiles);
        }
        else{
            for(int i = 0; i < board.getNumOfPlayerZones(); ++i){
                DiscardPile pile = board.getPlayerZoneAt(i).getDPile();
                if(listOfDPiles.size() == handle.getMin()){
                    break;
                }
                listOfDPiles.add(pile);
            }
        }
        if(listOfDPiles.size() == handle.getMin()){
            handle.getResultHandler().handle(listOfDPiles);
        }else{
            handle.getCancelHandler().cancel();
        }
    }
    
}
