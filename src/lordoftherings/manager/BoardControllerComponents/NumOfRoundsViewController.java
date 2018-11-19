//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.boardcomponents.NumOfRoundsTracker;
import lordoftherings.gui.NumOfRoundsView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsViewController {
    private BoardViewController boardVC;
    private NumOfRoundsView view;
    private NumOfRoundsTracker tracker;
    
    public NumOfRoundsViewController(BoardViewController boardVC, 
            NumOfRoundsTracker tracker){
        this.boardVC = boardVC;
        this.tracker = tracker;
    }
    
    public NumOfRoundsView makeView(int x, int y){
        view = new NumOfRoundsView(x, y, tracker.getNumOfRounds());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        view.setText("" +tracker.getNumOfRounds());
        view.revalidate();
        view.repaint();
    }
}
