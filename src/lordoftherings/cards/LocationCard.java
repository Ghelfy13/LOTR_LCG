//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.cards;

import java.util.ArrayList;
import lordoftherings.PlayerCardType;
import lordoftherings.actions.Action;
import lordoftherings.actions.SelectActiveLocationAction;
import lordoftherings.boardcomponents.Board;
import lordoftherings.cardmodel.EncounterCardModel;
import lordoftherings.cardmodel.LocationCardModel;

/**
 *
 * @author Amanda
 */

public class LocationCard extends EncounterCard {
    private LocationCardModel cardModel;
    private SelectActiveLocationAction makeActiveLocation;
    
    public LocationCard(LocationCardModel model){
        this.cardModel = model;
        this.makeActiveLocation = new SelectActiveLocationAction(this);
    }
    
    @Override
    public EncounterCardModel getModel() {
        return cardModel;
    }

    @Override
    public void afterOnWhenRevealed(Board board) {
        //TODO
    }

    @Override
    public PlayerCardType getCardType() {
        return PlayerCardType.LOCATION;
    }

    public String getTitle() {
        return cardModel.geTitle();
    }
    
    @Override
    public void getActions(ArrayList<Action> listOfActions, Board board, int askingID){
        super.getActions(listOfActions, board, askingID);
        makeActiveLocation.updateActionState(askingID, board);
        if(makeActiveLocation.isAvailable()){
            listOfActions.add(makeActiveLocation);
        }
    }
}
