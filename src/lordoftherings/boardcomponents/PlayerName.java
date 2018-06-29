//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

/**
 *
 * @author Amanda
 */
public class PlayerName {
    
    private PlayerZone zone;
    private String name;
    private int ownerID;
    
    public PlayerName(String name, int ownerID, PlayerZone zone){
        this.zone = zone;
        this.name = name;
        this.ownerID = ownerID;
    }
    
    public String getPlayerName(){
        return name;
    }
    
    public PlayerZone getPlayerZone(){
        return zone;
    }
    
    public int getOwnerID(){
        return ownerID;
    }
}
