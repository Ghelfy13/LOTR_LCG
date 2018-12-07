//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.NumOfRoundsTracker;
import lordoftherings.gui.NumOfRoundsLabelView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsLabelViewController {
    private BoardViewController boardVC;
    private NumOfRoundsLabelView view;
    private GameConfiguration config;
    
    public NumOfRoundsLabelViewController(BoardViewController boardVC, GameConfiguration config){
        this.boardVC = boardVC;
        this.config = config;
    }
    
    public NumOfRoundsLabelView makeView(int x, int y){
        view = new NumOfRoundsLabelView(x, y, config);
        view.setVisible(true);
        return view;
    }
}
