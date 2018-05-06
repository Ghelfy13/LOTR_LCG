//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.actions;

import lordoftherings.LocationOnBoard;
import lordoftherings.PhaseManager.TravelSubPhase;
import lordoftherings.boardcomponents.ActiveLocationArea;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.StagingArea;
import lordoftherings.cards.LocationCard;
import lordoftherings.characters.Location;

/**
 *
 * @author Amanda
 */
public class SelectActiveLocationAction extends Action{
    private LocationCard desiredCard;

    public SelectActiveLocationAction(LocationCard desiredCard) {
        super(getDescription(desiredCard));
        this.desiredCard = desiredCard;
    }
    
    private static String getDescription(LocationCard desiredCard){
        return "Travel to " + desiredCard.getTitle();
    }
    @Override
    public boolean execute(int askingID, Board boardState) {
        StagingArea stage = boardState.getEncounterZone().getStagingArea();
        ActiveLocationArea activeArea = stage.getActiveLocationArea();
        Location wantedLocation = stage.getLocationArea().findLocationByCard(desiredCard);
        if(activeArea.isEmpty() && wantedLocation != null){
            activeArea.setActiveLocation(wantedLocation);
            stage.getLocationArea().removeLocation(wantedLocation);
            return true;
        }
        return false;
    }

    @Override
    public void updateActionState(int askingID, Board boardState) {
        if(boardState.getCurrentSubPhase() == TravelSubPhase.SELECT_ACTIVE_LOCATION &&
                askingID == boardState.getCurrentPlayerNum() &&
                desiredCard.getLocation() == LocationOnBoard.ENCOUNTER_ZONE){
            if(boardState.getEncounterZone().getStagingArea().getActiveLocationArea().isEmpty()){
                state = ActionState.EXECUTABLE;      
            }else{
                state = ActionState.VISIBLE;
            }
        } else {
            state = ActionState.NOTAVAILABLE;
        }
    }
    
}
