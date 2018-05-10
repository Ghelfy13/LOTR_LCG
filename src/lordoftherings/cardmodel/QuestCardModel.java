//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.Identification;
import lordoftherings.DeckComponents.ScenarioSymbol;

/**
 *
 * @author Amanda
 */
public class QuestCardModel {
    protected String title;
    protected ScenarioSymbol symbol;
    protected String[] encounterInfo;//list of symbols of cards to be in deck
    protected String setInfo;//describes goal of quest
    protected String scenarioTitle;
    protected Identification cardID;
    protected int questPoints;
    
    public QuestCardModel(
        String title,
        ScenarioSymbol symbol,
        String [] encounterInfo,
        String setInfo,
        String scenarioTitle,
        Identification cardID,
        int questPoints){
        this.title = title;
        this.symbol = symbol;
        this.encounterInfo = encounterInfo;
        this.setInfo = setInfo;
        this.scenarioTitle = scenarioTitle;
        this.cardID = cardID;
        this.questPoints = questPoints;
    }
    
    public String getTitle(){
        return title;
    }
    
    public ScenarioSymbol getSymbol(){
        return symbol;
    }
    
    public String[] getEncounterInfo(){
        return encounterInfo;
    }
    
    public String getScenarioTitle(){
        return scenarioTitle;
    }
    
    public Identification getCardID(){
        return cardID;
    }
    
    public int getQuestPoints(){
        return questPoints;
    }
    
   
}
