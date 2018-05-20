//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Amanda
 */
public class ProgressPhaseActionListener implements ActionListener{
    private GameManagerViewController gameManagerVC;
    private BoardViewController boardVC;
    
    public ProgressPhaseActionListener(GameManagerViewController gameManagerVC,
            BoardViewController boardVC){
        this.gameManagerVC = gameManagerVC;
        this.boardVC = boardVC;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        gameManagerVC.updateView();
        boardVC.updatePhase();
    }
    
    
}
