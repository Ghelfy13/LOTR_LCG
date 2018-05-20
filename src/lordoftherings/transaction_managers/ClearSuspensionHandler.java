//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class ClearSuspensionHandler extends CancelHandler{
    private Board board;
    
    public ClearSuspensionHandler(Board board){
        this.board = board;
    }
    
    @Override
    public boolean canCancel() {
        return true;
    }

    @Override
    protected void dispatchCancel() {
        board.removeRecentSuspension();
    }
    
}
