//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.DeckViewController;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class DeckViewParent extends JPanel{
    private DeckView view;
    
    public DeckViewParent(DeckViewController controller, 
            int x, int y, GameConfiguration config){
        view = new DeckView(controller, config);
        this.add(view);
        this.setBounds(config.scale(x), config.scale(y),
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(HandCardView.CARD_HEIGHT));
        this.setOpaque(false);
        BoardActiveState bas = controller.getBoardActiveStateController();
        this.addMouseListener(new FocusableMouseListener(bas,controller));
    }
    
    public DeckView getView(){
        return view;
    }
}
