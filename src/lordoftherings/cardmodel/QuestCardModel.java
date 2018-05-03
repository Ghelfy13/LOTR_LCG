//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import java.util.ArrayList;
import lordoftherings.Identification;
import lordoftherings.DeckComponents.QuestScenarioSymbol;

/**
 *
 * @author Amanda
 */
public class QuestCardModel {
    protected String title;
    protected QuestScenarioSymbol symbol;
    protected ArrayList<String> encounterInfo;
    protected String scenarioTitle;
    protected Identification cardID;
    protected int questPoints;
    
    public QuestCardModel(
        String title,
        QuestScenarioSymbol symbol,
        ArrayList<String> encounterInfo,
        String scenarioTitle,
        Identification cardID,
        int questPoints){
        this.title = title;
        this.symbol = symbol;
        this.encounterInfo = encounterInfo;
        this.scenarioTitle = scenarioTitle;
        this.cardID = cardID;
        this.questPoints = questPoints;
    }
    
    public String getTitle(){
        return title;
    }
    
    public QuestScenarioSymbol getSymbol(){
        return symbol;
    }
    
    public ArrayList<String> getEncounterInfo(){
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
    
    public void setSymbol(QuestScenarioSymbol newSymbol){
        symbol = newSymbol;
    }
    
    public void addEncounterInfo(String newInfo){
        encounterInfo.add(newInfo);
    }
    
    public String removeInfoAt(int infoIndex){
        String wantedInfo = encounterInfo.get(infoIndex);
        encounterInfo.remove(infoIndex);
        return wantedInfo;
    }
    
    public void setQuestPoints(int questingValue){
        questPoints = questingValue;
    }
}
