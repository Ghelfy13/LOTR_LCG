//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.manager.actionComponents.Selectable;
import lordoftherings.manager.actionComponents.SelectableActiveState;

/**
 *
 * @author Amanda
 */
public class PlayerQueryActiveState extends SelectableActiveState<PlayerZone> {

    private PlayerQueryViewController playerQVC;
    
    public PlayerQueryActiveState(PlayerQueryViewController playerQVC){
        super(playerQVC);
        this.playerQVC = playerQVC;
    }
    
    @Override
    public void selectOrDeselect(Selectable<PlayerZone> selectedElement) {
        if(playerQVC.resultContains(selectedElement.get())){
            selectedElement.onDeselect();
            playerQVC.removeFromResult(selectedElement.get());
        }
        else{
            if(!playerQVC.resultIsFull()){
                selectedElement.onSelect();
                playerQVC.addToResult(selectedElement.get());
            }
        }
        playerQVC.updateView();
    }
    
}
