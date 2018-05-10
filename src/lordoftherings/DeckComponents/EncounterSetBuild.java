//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;

import lordoftherings.boardcomponents.QuestSet;

/**
 *
 * @author Amanda
 */
public class EncounterSetBuild {
    private EncounterDeckBuild enemyDeckBuild;
    private QuestSet questCollection;
    
    public EncounterSetBuild(EncounterDeckBuild enemyBuild, QuestSet quests){
        this.enemyDeckBuild = enemyBuild;
        this.questCollection = quests;
    }
    
    public QuestSet getQuestSet(){
        return questCollection;
    }
    
    public EncounterDeckBuild getEncounterDeckBuild(){
        return enemyDeckBuild;
    }
}
