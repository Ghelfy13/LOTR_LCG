//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.gui.PhaseView;

/**
 *
 * @author Amanda
 */
public class PhaseViewController {
    
    private BoardViewController boardVC;
    private PhaseView view;
    
    public PhaseViewController(BoardViewController boardVC){
        this.boardVC = boardVC;
    }
    
    public PhaseView makeView(int x, int y){
        String currentPhase = boardVC.getCurrentPhase();
        view = new PhaseView(currentPhase,x, y);
        view.setVisible(true);
        return view;
    }
    
    public PhaseView updateView(){
        view.setText(boardVC.getCurrentPhase());
        view.revalidate();
        view.repaint();
        return view;
    }
}
