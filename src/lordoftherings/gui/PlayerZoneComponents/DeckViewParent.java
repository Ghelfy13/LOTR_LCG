//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.DeckViewController;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class DeckViewParent extends JPanel{
    private DeckView view;
    
    public DeckViewParent(DeckViewController controller){
        view = new DeckView(controller);
        this.add(view);
        this.setBounds(250,300,180,250);
        this.setOpaque(false);
        BoardActiveState bas = controller.getBoardActiveStateController();
        this.addMouseListener(new FocusableMouseListener(bas,controller));
    }
    
    public DeckView getView(){
        return view;
    }
}
