//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.deckcomponents;


/**
 *
 * @author Amanda
 */
public class EncounterBuild {
    private EncounterDeckBuild enemyDeck;
    private QuestSetBuild quests;
      
    
    public EncounterBuild(EncounterDeckBuild enemyDeck, QuestSetBuild quests){
        this.enemyDeck = enemyDeck;
        this.quests = quests;
    }
    
    public EncounterDeckBuild getEnemyDeck(){
        return enemyDeck;
    }
    
    public QuestSetBuild getQuestDeck(){
        return quests;
    }
    
   
    
}
