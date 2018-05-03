//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.boardcomponents;

import lordoftherings.cards.HeroCard;
import lordoftherings.cards.AllyCard;
import java.util.ArrayList;
/**
 *
 * @author Amanda
 */
public class Field {//Is subPart of the PlayerZone where all the faceup cards go
    private CharacterArea characterZone;
    private int ownerID;
    private EngagedEnemyArea engagementArea;
    private boolean engagedEnemyYet;
    private PlayerZone playerZone;
    
    public Field(ArrayList<HeroCard> myHeros, int ownerID, PlayerZone zone){
        this.engagementArea = new EngagedEnemyArea(ownerID, zone);
        characterZone = new CharacterArea(myHeros, zone);
        this.ownerID = ownerID;
        this.engagedEnemyYet = false;
        this.playerZone = zone;
    }
    
    public int getInitinalThreat(){
        HeroArea heroArea = characterZone.getHeroArea();
        int numOfHeros = heroArea.getNumOfHeros();
        int totalThreat = 0;
        for(int i = 0; i < numOfHeros; ++i){
            totalThreat += heroArea.getHeroAt(i).getThreatCost();
        }
        return totalThreat;
    }
    
    public int getNumOfResources(){
        return characterZone.getHeroArea().sumOfResources();
    }
    
    public boolean canAfford(AllyCard myAlly){
        int cost = myAlly.getCost();
        int numResources = characterZone.getTotalNumResources();
        return (cost <= numResources);
    }
    
    public String setReason(AllyCard myAlly){
        return "";
        //TODO
    }
    
    public boolean addAllyToCharacterZone(AllyCard newCard){
        return characterZone.addAllyToAllyZone(newCard);
    }
    
    public CharacterArea getCharacterZone() {
        return characterZone;
    }

    EngagedEnemyArea getEngagementArea() {
        return engagementArea;
    }

    public boolean hasEngagedEnemyYet() {
        return engagedEnemyYet;
    }
    
    public void setEngagedEnemyYet(boolean bool){
        engagedEnemyYet = bool;
    }

}
