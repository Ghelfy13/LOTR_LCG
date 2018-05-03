//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Amanda
 */
public class ProgressPhaseActionListener implements ActionListener{
    private BoardViewController boardVC;
    
    public ProgressPhaseActionListener(BoardViewController boardController){
        boardVC = boardController;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        boardVC.updatePhase();
    }
    
    
}
