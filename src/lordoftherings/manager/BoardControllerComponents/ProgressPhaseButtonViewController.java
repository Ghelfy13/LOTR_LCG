//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.Color;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.ProgressPhaseButtonView;

/**
 *
 * @author Amanda
 */
public class ProgressPhaseButtonViewController {
    private ProgressPhaseButtonView phaseButtonView;
    private GameManagerViewController gameManagerVC;
    private GameConfiguration config;
    
    public ProgressPhaseButtonViewController(GameManagerViewController gameManagerVC, GameConfiguration config){
        this.gameManagerVC = gameManagerVC;
        this.config = config;
    }
    
    public ProgressPhaseButtonView makeView(int x, int y){
        phaseButtonView = new ProgressPhaseButtonView(x, y, config);
        phaseButtonView.setVisible(true);
        return phaseButtonView;
    }
    
    public void updateView(){
        if(!gameManagerVC.getBoard().getPhaseManagerGovenor().canProgressPhase()){
            phaseButtonView.setBackground(Color.LIGHT_GRAY);
        }else{
            phaseButtonView.setBackground(Color.CYAN);
        }
        phaseButtonView.revalidate();
        phaseButtonView.repaint();
    }
}
