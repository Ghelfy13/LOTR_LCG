//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.DeckComponents;
import lordoftherings.cards.HeroCard;
import lordoftherings.cardmodel.HeroCardModel;
import java.util.ArrayList;
/**
 *
 * @author Amanda
 */
public class PlayerDeckBuild {
    private DeckBuild playersDeck;
    private ArrayList<HeroCardModel> modelCitizen;
    
    
    public PlayerDeckBuild(DeckBuild deck){
        this.playersDeck = deck;
        modelCitizen = new ArrayList(); 
    }
    
    public DeckBuild getPlayersDeck(){
        return playersDeck;
    }
    
    public void addHero(HeroCardModel heroToBeAdded){
        modelCitizen.add(heroToBeAdded);
    }
    
    public void removeHero(HeroCardModel heroToBeRemoved){
        modelCitizen.remove(heroToBeRemoved);
    }
    
    public ArrayList<HeroCard> getHeros(){
        ArrayList<HeroCard> outstandingCitizen = new ArrayList<>();
        for(int i = 0; i < modelCitizen.size(); ++i){
            outstandingCitizen.add(modelCitizen.get(i).createCard());
        }
        return outstandingCitizen;
    }
}


