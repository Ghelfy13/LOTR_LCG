//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.transaction_managers;

import lordoftherings.deckcomponents.EncounterBuild;
import lordoftherings.deckcomponents.PlayerDeckBuild;
import lordoftherings.boardcomponents.Board;
import lordoftherings.manager.query_Handlers.PlayerQueryHandler;

/**
 *
 * @author Amanda
 */
public class GameManager {
    
    private Board board;
    private DefaultCharacterQueryHandler defaultCharQH;
    private CharacterQueryHandler customCharQH;
    private DefaultPlayerQueryHandler playerZoneQH;
    private PlayerQueryHandler customPlayerQH;
    
    
    public GameManager(PlayerDeckBuild[] playerBuilds, EncounterBuild encounterInfo){
        board = new Board(playerBuilds, encounterInfo, this);
        this.defaultCharQH = new DefaultCharacterQueryHandler(board);
        this.customCharQH = null;
        this.playerZoneQH = new DefaultPlayerQueryHandler(board);
        this.customPlayerQH = null;
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
    
    public void handlePlayerZoneQuery(PlayerQueryHandle handle, String description){
        if(customPlayerQH == null){
            playerZoneQH.handleQuery(handle, description);
        }else{
            customPlayerQH.handleQuery(handle, description);
        }
        
    }
    
    public void setCustomCharacterQueryHandler(CharacterQueryHandler newCustom){
        customCharQH = newCustom;
    }
    public void setCustomPlayerQueryHandler(PlayerQueryHandler newCustom){
        customPlayerQH = newCustom;
    }
    
    public void unsetCustomQueryHandler(){
        customCharQH = null;
    }
}
