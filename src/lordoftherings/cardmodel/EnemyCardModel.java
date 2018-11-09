//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.EncounterType;
import lordoftherings.Identification;
import lordoftherings.cards.EnemyCard;

/**
 *
 * @author Amanda
 */
public class EnemyCardModel extends EncounterCardModel{
    protected int engagementCost;
    protected int threat;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    
    public EnemyCardModel(
    String title, 
    EncounterType type,
    String [] traits,
    Identification cardID,
    int engagementCost,
    int threat,
    int attack,
    int defense,
    int hitPoints,
    int victoryPoints,
    String effect){
        super(title, type, traits, cardID, effect, victoryPoints);
        this.engagementCost = engagementCost;
        this.threat = threat;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }
    
    public EncounterType getType(){
        return type;
    }
    
    public boolean hasVictoryPoints(){
        return victoryPoints != 0;
    }
    
    public int getVictoryPoints(){
        return victoryPoints;
    }
    
    public int getEngagementCost(){
        return engagementCost;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public int getHitPoints(){
        return hitPoints;
    }
    
    public String[] getTraits(){
        return traits;
    }
    
    public String getTitle(){
        return title;
    }
    
    @Override
    public String identify(){
        return title.toUpperCase()+ "\n" + "\n" + "Encounter Type: " + type +
                "\n" + "Traits: " + identifyTraits() + "Engagement Cost: " + 
                engagementCost + "\n" + "Threat Value: " + threat + "\n" +
                "Attack: " + attack + "\n" + "Defense: " + defense + "\n" +
                "Hit Points: " + hitPoints + "\n" + '\n' + effect ;
    }
    
    @Override
    public int getThreat(){
        return threat;
    }
    @Override
    public Identification getCardID() {
        return cardID;
    }

    @Override
    public EnemyCard createCard() {
        EnemyCard card = new EnemyCard(this);
        return card;
    }

    @Override
    public String getEffect() {
        return effect;
    }
}
