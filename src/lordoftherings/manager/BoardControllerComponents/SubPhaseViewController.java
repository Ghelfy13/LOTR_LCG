//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.phasemanager.SubPhase;
import lordoftherings.gui.SubPhaseView;

/**
 *
 * @author Amanda
 */
public class SubPhaseViewController {
    private SubPhaseView view;
    private BoardViewController boardVC;
    private SubPhase phase;
    private GameConfiguration config;
    
    public SubPhaseViewController(BoardViewController boardVC, GameConfiguration config){
        this.boardVC= boardVC;
        this.phase = boardVC.getBoard().getPhaseManagerGovenor().getCurrentSubPhase();
        this.config = config;
    }
    
    public SubPhaseView makeView(int x, int y){
        view = new SubPhaseView(boardVC.getCurrentSubPhase(),x, y, config);
        view.setVisible(true);
        return view;
    }
    
    public SubPhaseView updateView(){
        view.setText(boardVC.getCurrentSubPhase());
        view.revalidate();
        view.repaint();
        return view;
    }
}
