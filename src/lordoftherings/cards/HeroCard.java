//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.LocationOnBoard;
import lordoftherings.PlayerCardType;
import lordoftherings.actions.Action;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.HeroCardModel;

/**
 *
 * @author Amanda
 */
public class HeroCard extends CharacterCard {
    private HeroCardModel myHero;
    
    private HeroCard(HeroCardModel myHero){
        super(myHero);
        this.myHero = myHero;
    }
    
    private HeroCard(LocationOnBoard cardLocation,
            int ownerID, 
            int controllerID, 
            HeroCardModel myHero){
        super(cardLocation, ownerID, controllerID, myHero);
        this.myHero = myHero;
    }
    
    public static HeroCard get(HeroCardModel model){
        HeroCard result = new HeroCard(model);
        result.instantiateActions();
        return result;
    }
    
    public int getThreatCost(){
        return myHero.getThreatCost();
    }
    
    @Override
    public HeroCardModel getCardModel(){
        return myHero;
    }
    
    @Override
    public void getActions(ArrayList<Action> listOfActions, Board boardState, int askingID){
        super.getActions(listOfActions, boardState, askingID);
    }

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.HERO;
    }
}
