//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

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
    
    public SubPhaseViewController(BoardViewController boardVC){
        this.boardVC= boardVC;
        this.phase = boardVC.getBoard().getPhaseManagerGovenor().getCurrentSubPhase();
    }
    
    public SubPhaseView makeView(int x, int y){
        view = new SubPhaseView(boardVC.getCurrentSubPhase(),x, y);
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
