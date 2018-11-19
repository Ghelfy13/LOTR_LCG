//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.boardcomponents.NumOfRoundsTracker;
import lordoftherings.gui.NumOfRoundsLabelView;

/**
 *
 * @author Amanda
 */
public class NumOfRoundsLabelViewController {
    private BoardViewController boardVC;
    private NumOfRoundsLabelView view;
    
    public NumOfRoundsLabelViewController(BoardViewController boardVC,
            NumOfRoundsTracker tracker){
        this.boardVC = boardVC;
    }
    
    public NumOfRoundsLabelView makeView(int x, int y){
        view = new NumOfRoundsLabelView(x, y);
        view.setVisible(true);
        return view;
    }
}
