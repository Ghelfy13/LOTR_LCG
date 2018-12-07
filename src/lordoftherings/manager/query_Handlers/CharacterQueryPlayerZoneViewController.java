//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.query_components.QueryCharacterAreaView;
import lordoftherings.gui.query_components.QueryPlayerZoneView;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.CHAR_AREA_X;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.CHAR_AREA_Y;
import lordoftherings.transaction_managers.CharacterQueryHandle;

/**
 *
 * @author Amanda
 */
public class CharacterQueryPlayerZoneViewController {
    private QueryPlayerZoneView zoneView;
    private CharacterQueryViewController queryVC;
    private PlayerZone playerZone;
    private QueryCharacterAreaViewController charAreaVC;
    private CharacterQueryActiveState charQAS;
    private CharacterQueryHandle handle;
    private GameConfiguration config;
    
    
    public CharacterQueryPlayerZoneViewController(CharacterQueryViewController queryController,
            PlayerZone playerZone, CharacterQueryActiveState charQAS, GameConfiguration config){
        this.playerZone = playerZone;
        this.queryVC = queryController;
        this.charAreaVC = new QueryCharacterAreaViewController(
                this, playerZone.getCharZone().getHeroArea(), 
                playerZone.getCharZone().getAllyArea(),
                charQAS, config);
        this.charQAS = charQAS;
        this.handle = (CharacterQueryHandle) queryController.getHandle();
        this.config = config;
    }
    
    public QueryPlayerZoneView makeView(int x, int y){
        zoneView = new QueryPlayerZoneView(x, y, config);
        zoneView.addMouseMotionListener(charQAS.createMouseFollower());
        QueryCharacterAreaView charAreaView = charAreaVC.makeView(CHAR_AREA_X, 
                CHAR_AREA_Y);
        zoneView.add(charAreaView);
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
        playerZone.getEngagementArea().cleanUpEngagedEnemyArea();
    }
}
