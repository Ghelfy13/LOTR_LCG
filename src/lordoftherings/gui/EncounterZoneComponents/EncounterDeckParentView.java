//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import javax.swing.JPanel;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterDeckViewController;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class EncounterDeckParentView extends JPanel{
    private EncounterDeckView view;
    
    
    public EncounterDeckParentView(EncounterDeckViewController controller, 
            int x, int y, GameConfiguration config){
        view = new EncounterDeckView(controller, config);
        this.add(view);
        this.setBounds(config.scale(x), config.scale(y), 
                config.scale(HandCardView.CARD_WIDTH), 
                config.scale(HandCardView.CARD_HEIGHT));
        this.setOpaque(false);
        BoardActiveState bas = controller.getBoardActiveStateController();
        this.addMouseListener(new FocusableMouseListener(bas,controller));
    }
    
    public EncounterDeckView getView(){
        return view;
    }
}
