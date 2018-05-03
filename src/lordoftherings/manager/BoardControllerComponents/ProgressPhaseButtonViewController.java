//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.Color;
import lordoftherings.gui.ProgressPhaseButtonView;

/**
 *
 * @author Amanda
 */
public class ProgressPhaseButtonViewController {
    private BoardViewController boardVC;
    private ProgressPhaseButtonView phaseButtonView;
    
    public ProgressPhaseButtonViewController(BoardViewController boardVC){
        this.boardVC = boardVC;
    }
    
    public ProgressPhaseButtonView makeView(int x, int y){
        phaseButtonView = new ProgressPhaseButtonView(x,y);
        phaseButtonView.setVisible(true);
        return phaseButtonView;
    }
    
    public void updateView(){
        if(!boardVC.getBoard().canProgressPhase()){
            phaseButtonView.setBackground(Color.LIGHT_GRAY);
        }else{
            phaseButtonView.setBackground(Color.CYAN);
        }
        phaseButtonView.revalidate();
        phaseButtonView.repaint();
    }
}
