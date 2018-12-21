//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Amanda
 */
public class PlayerName {
    
    private PlayerZone zone;
    private String name;
    private int ownerID;
    private Scanner screen;
    
    public PlayerName(int ownerID, PlayerZone zone, String name){
        this.zone = zone;
        this.ownerID = ownerID;
        this.name = name;
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
