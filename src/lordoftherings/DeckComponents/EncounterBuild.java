//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;

import lordoftherings.boardcomponents.QuestSet;
import lordoftherings.cards.QuestCard;

/**
 *
 * @author Amanda
 */
public class EncounterBuild {
    private EncounterDeckBuild enemyDeck;
    private QuestSet quests;
      
    
    public EncounterBuild(EncounterDeckBuild enemyDeck, QuestSet quests){
        this.enemyDeck = enemyDeck;
        this.quests = quests;
    }
    
    public EncounterDeckBuild getEnemyDeck(){
        return enemyDeck;
    }
    
    public QuestSet getQuestDeck(){
        return quests;
    }
    
    public void addQuest(QuestCard newQuest){
        quests.addQuest(newQuest);
    }
    
    public QuestCard removeQuest(QuestCard wantedQuest){
        quests.removeQuest(wantedQuest);
        return wantedQuest;
    }
    
}
