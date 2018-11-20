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
        int playerBaseScore = board.getPlayerZoneAt(0).getCurrentPlayerThreat() + 
                board.getPlayerZoneAt(0).getTotalDamageOnHeros() +
                board.getPlayerZoneAt(0).getSumOfThreatOfDeadHeros();
        int baseWithVPoints = playerBaseScore - board.getVPPile().getVictoryPoints();
        int baseWithVPAndRounds = baseWithVPoints + board.getNumOfRounds().getNumOfRounds()*10;
        if(board.hasGameEnded()){
            if(board.getPlayerStatus()){
                String firstLine = "You've completed: " + board.getQuestName() + "\n" + "\n";
                String secondLine = "Calculation of score: " + "\n";
                String score = "Threat: " + board.getPlayerZoneAt(0).getCurrentPlayerThreat() + "  " + 
                        "Damage on Heros: " + board.getPlayerZoneAt(0).getTotalDamageOnHeros() +"  " + 
                        "Threat of Dead Heros: " + board.getPlayerZoneAt(0).getSumOfThreatOfDeadHeros() + "\n";
                String victoryPoints = "Score - Victory Points: " + 
                        playerBaseScore + " - " + board.getVPPile().getVictoryPoints() + " = " + 
                                (baseWithVPoints)+  "\n";
                String rounds = "Score + Number of rounds X 10: " +
                        baseWithVPoints+" + "+board.getNumOfRounds().getNumOfRounds()*10 +
                        " = " + baseWithVPAndRounds + "\n";
                String totalScore = "Total Score: " + board.calculateEndGameScore();
                messageView = new EndOfGameMessageView(X_VALUE, Y_VALUE, firstLine +
                        secondLine + score + victoryPoints + rounds + totalScore);
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
