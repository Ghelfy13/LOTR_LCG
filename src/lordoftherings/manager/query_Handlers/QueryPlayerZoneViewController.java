//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.gui.query_components.QueryCharacterAreaView;
import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.Y_HAND_VALUE;
import lordoftherings.transaction_managers.CharacterQueryHandle;

/**
 *
 * @author Amanda
 */
public class QueryPlayerZoneViewController {
    private QueryPlayerZoneView zoneView;
    private CharacterQueryViewController queryVC;
    private PlayerZone playerZone;
    private QueryCharacterAreaViewController charAreaVC;
    private CharacterQueryActiveState charQAS;
    private CharacterQueryHandle handle;
    private QueryPlayerNameViewController playerNameVC;
    
    
    public QueryPlayerZoneViewController(CharacterQueryViewController queryController,
            PlayerZone playerZone, CharacterQueryActiveState charQAS){
        this.playerZone = playerZone;
        this.queryVC = queryController;
        this.charAreaVC = new QueryCharacterAreaViewController(
                this, playerZone.getCharZone().getHeroArea(), 
                playerZone.getCharZone().getAllyArea(),
                charQAS);
        this.charQAS = charQAS;
        this.handle = queryController.getHandle();
        this.playerNameVC = new QueryPlayerNameViewController("Player1", charQAS, playerZone.getOwner());
    }
    
    public QueryPlayerZoneView makeView(int x, int y){
        zoneView = new QueryPlayerZoneView(x, y);
        zoneView.addMouseMotionListener(charQAS.createMouseFollower());
        QueryPlayerNameView nameView = playerNameVC.makeView(60, Y_HAND_VALUE - 100);
        QueryCharacterAreaView charAreaView = charAreaVC.makeView(
                PlayerZoneViewController.DECK_X + HandCardView.CARD_WIDTH + 20, 
                HandCardView.CARD_HEIGHT + 
                PlayerZoneViewController.DISTANCE_BT_FIELDS);
        zoneView.add(charAreaView);
        zoneView.add(nameView);
        nameView.setVisible(true);
        charAreaView.setVisible(true);
        zoneView.setVisible(true);
        return zoneView;
    }
    
    public CharacterQueryHandle getHandle(){
        return handle;
    }
    
    public void updateView(){
        charAreaVC.updateView();
        
    }
    
    public void deleteFallenCharacters(){
        playerZone.cleanUpCharacterArea();
        playerZone.getEngagementArea().moveDeadEnemiesToDiscardPile();
    }
}
