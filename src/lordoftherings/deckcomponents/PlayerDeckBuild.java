//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.deckcomponents;
import lordoftherings.cards.HeroCard;
import lordoftherings.cardmodel.HeroCardModel;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Amanda
 */
public class PlayerDeckBuild {
    private DeckBuild playersDeck;
    private ArrayList<HeroCardModel> listOfHeros;
    private String playerName;
    
    
    public PlayerDeckBuild(DeckBuild deck){
        this.playersDeck = deck;
        listOfHeros = new ArrayList(); 
        this.playerName = "Ducky Overlord";
    }
    
    public DeckBuild getPlayersDeck(){
        return playersDeck;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    
    public void addHero(HeroCardModel heroToBeAdded){
        listOfHeros.add(heroToBeAdded);
    }
    
    public void removeHero(HeroCardModel heroToBeRemoved){
        listOfHeros.remove(heroToBeRemoved);
    }
    
    public ArrayList<HeroCard> getHeros(){
        ArrayList<HeroCard> outstandingCitizen = new ArrayList<>();
        for(int i = 0; i < listOfHeros.size(); ++i){
            outstandingCitizen.add(listOfHeros.get(i).createCard());
        }
        return outstandingCitizen;
    }
}


