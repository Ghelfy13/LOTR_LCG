//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.boardcomponents.VictoryPointsPile;
import lordoftherings.gui.VictoryPointsLabelView;

/**
 *
 * @author Amanda
 */
public class VictoryPointsLabelViewController {
    
    private BoardViewController boardVC;
    private VictoryPointsPile pile;
    private VictoryPointsLabelView view;
    
    public VictoryPointsLabelViewController(BoardViewController boardVC, VictoryPointsPile pile){
        this.boardVC = boardVC;
        this.pile = pile;
    }
    
    public VictoryPointsLabelView makeView(int x, int y){
        view = new VictoryPointsLabelView(x, y, pile.getVictoryPoints());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        view.setText("Total Victory Points: " + pile.getVictoryPoints());
        view.revalidate();
        view.repaint();
    }
}
