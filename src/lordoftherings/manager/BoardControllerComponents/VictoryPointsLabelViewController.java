//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.GameConfiguration;
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
    private GameConfiguration config;
    
    public VictoryPointsLabelViewController(BoardViewController boardVC, 
            VictoryPointsPile pile, GameConfiguration config){
        this.boardVC = boardVC;
        this.pile = pile;
        this.config = config;
    }
    
    public VictoryPointsLabelView makeView(int x, int y){
        view = new VictoryPointsLabelView(x, y, pile.getVictoryPoints(), config);
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        view.setText("Total Victory Points: " + pile.getVictoryPoints());
        view.revalidate();
        view.repaint();
    }
}
