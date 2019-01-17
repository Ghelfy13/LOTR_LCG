//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cardmodel;

import lordoftherings.game_engine.GameData.Identification;
import lordoftherings.deckcomponents.ScenarioSymbol;

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
    
    public String identifyTraits(){
        StringBuilder myString = new StringBuilder();
        int length = encounterInfo.length;
        for(int i = 0; i < length; ++i){
            if( i == length -1){
                myString.append(encounterInfo[i] + '\n');
            }else{
                myString.append(encounterInfo[i] + ", ");
            }
        }
        return myString.toString();
    }
    
    public String identify(){
        return title.toUpperCase()+ "\n" + 
                scenarioTitle  + "\n" + "\n" +
                "Traits: " + identifyTraits() + "\n" +
                "Quest Points: " + questPoints + "\n";
    }
    
   
}
