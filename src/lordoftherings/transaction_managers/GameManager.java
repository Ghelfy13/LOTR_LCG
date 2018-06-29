//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.deckcomponents.EncounterBuild;
import lordoftherings.deckcomponents.PlayerDeckBuild;
import lordoftherings.boardcomponents.Board;

/**
 *
 * @author Amanda
 */
public class GameManager {
    
    private Board board;
    private DefaultCharacterQueryHandler defaultCharQH;
    private CharacterQueryHandler customCharQH;
    private PlayerZoneQueryHandler playerZoneQH;
    
    
    public GameManager(PlayerDeckBuild[] playerBuilds, EncounterBuild encounterInfo){
        board = new Board(playerBuilds, encounterInfo, this);
        this.defaultCharQH = new DefaultCharacterQueryHandler(board);
        this.customCharQH = null;
        this.playerZoneQH = new PlayerZoneQueryHandler(board);
    }
    
    public Board getBoard(){
        return board;
    }
   
    public void handleCharacterQuery(CharacterQueryHandle handle, String description){
        if(customCharQH == null){
            defaultCharQH.handleQuery(handle, description);
        }else{
            customCharQH.handleQuery(handle, description);
        }
    }
    
    public void handlePlayerZoneQuery(PlayerZoneQueryHandle handle, String description){
        playerZoneQH.handleQuery(handle, description);
    }
    
    public void setCustomQueryHandler(CharacterQueryHandler newCustom){
        customCharQH = newCustom;
    }
    
    public void unsetCustomQueryHandler(){
        customCharQH = null;
    }
}
