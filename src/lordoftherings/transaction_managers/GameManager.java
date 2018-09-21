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
    private DefaultPlayerQueryHandler playerZoneQH;
    private PlayerQueryHandler customPlayerQH;
    private DefaultEnemyQueryHandler enemyQH;
    private EnemyQueryHandler customEnemyQH;
    
    
    public GameManager(PlayerDeckBuild[] playerBuilds, EncounterBuild encounterInfo){
        board = new Board(playerBuilds, encounterInfo, this);
        this.defaultCharQH = new DefaultCharacterQueryHandler(board);
        this.customCharQH = null;
        this.playerZoneQH = new DefaultPlayerQueryHandler(board);
        this.customPlayerQH = null;
        this.enemyQH = new DefaultEnemyQueryHandler(board);
        this.customEnemyQH = null;
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
    
    public void handleEnemyQuery(EnemyQueryHandle handle, String description){
        if(customEnemyQH == null){
            enemyQH.handleQuery(handle, description);
        }else{
            customEnemyQH.handleQuery(handle, description);
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
    
    public void setCustomEnemyQueryHandler(EnemyQueryHandler newCustom){
        customEnemyQH = newCustom;
    }
    
    public void unsetCustomCharQueryHandler(){
        customCharQH = null;
    }
}
