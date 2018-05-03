//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

/**
 *
 * @author Amanda
 */
public class ThreatDial {
    
    private int threat;
    private PlayerZone zone;
    public static final int MAX_THREAT = 50;
    private int ownerID;
    
    public ThreatDial(int initialThreat, int ownerID, PlayerZone zone){
        this.zone = zone;
        this.threat = zone.getInitialThreat();
        this.ownerID = ownerID;
    }
    
    public void increaseThreat(int num){
        threat += num;
    }
    
    public int getOwnerID(){
        return ownerID;
    }
    
    public int getThreat(){
        return threat;
    }
    
    public void decreaseThreat(int num){
        threat -= num;
    }
    
    public int getMaxThreat(){
        return MAX_THREAT;
    }
    
    public PlayerZone getPlayerZone(){
        return zone;
    }
}
