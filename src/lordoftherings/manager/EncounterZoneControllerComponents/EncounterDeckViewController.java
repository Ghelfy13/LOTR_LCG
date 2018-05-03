//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import java.awt.event.MouseMotionListener;
import lordoftherings.boardcomponents.EncounterDeck;
import lordoftherings.gui.EncounterZoneComponents.EncounterDeckParentView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;

/**
 *
 * @author Amanda
 */
public class EncounterDeckViewController implements Focusable{
    private EncounterDeck enemyDeck;
    private EncounterZoneViewController zoneVC;
    private EncounterDeckParentView view;
    
    public EncounterDeckViewController(EncounterDeck deck, EncounterZoneViewController parentController){
        this.zoneVC = parentController;
        this.enemyDeck = deck;
    }
    
    public EncounterDeckParentView makeView(MouseMotionListener mmListener, int x, int y){
        view = new EncounterDeckParentView(this, x, y);
        view.addMouseMotionListener(mmListener);
        view.setVisible(true);
        return view;
    }

    public BoardActiveState getBoardActiveStateController() {
        return zoneVC.getBoardActiveState();
    }

     public void updateView(){
        if(enemyDeck.getNumOfCardsLeft() == 0){
            view.getView().setVisible(false);
        }
    }
  
    @Override
    public String getViewingText() {
        return enemyDeck.getNumOfCardsLeft() + " cards remain";
    }
}
