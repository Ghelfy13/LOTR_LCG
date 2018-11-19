//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.Color;
import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.EndOfGameMessageView;
import lordoftherings.gui.EndOfGameView;
/**
 *
 * @author Amanda
 */
public class EndOfGameViewController {
    private EndOfGameMessageView messageView;
    private EndOfGameView view;
    private Board board;
    public static final int X_VALUE = 300;
    public static final int Y_VALUE = 300;
    
    public EndOfGameViewController(Board myBoard){
        this.board = myBoard;
    }
    
    public EndOfGameView makeView(){
        view = new EndOfGameView();
        view.setVisible(false);
        return view;
    }
    
    public void updateView(){
        if(board.hasGameEnded()){
            if(board.getPlayerStatus()){
                messageView = new EndOfGameMessageView(X_VALUE, Y_VALUE, "Congratulations!  You've Won!" + " \n" + "Your score is: " + board.calculateEndGameScore());
                messageView.setForeground(Color.CYAN);
            }else{
                messageView = new EndOfGameMessageView(X_VALUE, Y_VALUE, "Heros Failed");
            }
            view.add(messageView);
            view.setVisible(true);
            view.revalidate();
            view.repaint();
        }
    }
}
