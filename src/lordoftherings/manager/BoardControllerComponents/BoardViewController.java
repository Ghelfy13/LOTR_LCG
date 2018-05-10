//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController;
import lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController;
import java.awt.Point;
import lordoftherings.boardcomponents.Board;
import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.gui.BoardView;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.PhaseView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;
import lordoftherings.gui.ProgressPhaseButtonView;
import lordoftherings.gui.SubPhaseView;
import lordoftherings.manager.actionComponents.GlobalViewController;

/**
 *
 * @author Amanda
 */
public class BoardViewController implements GlobalViewController {
    private PlayerZoneViewController playerZoneVC;
    private PhaseViewController phaseVC;
    private Board myBoard;
    private BoardView view;
    private BoardActiveState activeState;
    private GamePhase currentPhase;
    private ProgressPhaseButtonViewController phaseButtonController;
    private EncounterZoneViewController encounterZoneVC;
    private SubPhaseViewController subPhaseVC;
    private GameManagerViewController gameMVC;
    public static final int DISTANCE_FROM_FRAME = 10;
    public static final int DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE = 45;
    
    public BoardViewController(Board newBoard, GameManagerViewController managerVC){
        this.myBoard = newBoard;
        this.phaseVC = new PhaseViewController(this);
        this.view = null;
        this.activeState = new BoardActiveState(this);
        this.currentPhase = GamePhase.RESOURCE;
        this.encounterZoneVC = new EncounterZoneViewController(activeState, myBoard.getEncounterZone());
        this.playerZoneVC = new PlayerZoneViewController(this, myBoard.getPlayerZoneAt(0), activeState);
        this.subPhaseVC = new SubPhaseViewController(this);
        this.gameMVC = managerVC;
    }
    
    public BoardView makeView(int x, int y, int width, int height){
        view = new BoardView(x, y, width, height);
        view.add(activeState.getFocusableText());
        view.add(activeState.getAvailableActions());
        view.addMouseMotionListener(activeState.createMouseFollower());
        PlayerZoneView playerView = playerZoneVC.makeView(
                DISTANCE_FROM_FRAME, ActiveLocationView.CARD_COUNTER_HEIGHT + DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE);
        view.add(playerView);
        phaseVC = new PhaseViewController(this);
        PhaseView phaseView = phaseVC.makeView(width - PhaseView.PHASE_BUTTON_WIDTH, y);
        view.add(phaseView);
        phaseButtonController = new ProgressPhaseButtonViewController(this);
        ProgressPhaseButtonView phaseButtonView = phaseButtonController.makeView(
                width - (ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH + PhaseView.PHASE_BUTTON_WIDTH), y);
        ProgressPhaseActionListener ppActionListener = new ProgressPhaseActionListener(this);
        phaseButtonView.addActionListener(ppActionListener);
        view.add(phaseButtonView);
        EncounterZoneView enemyZoneView = encounterZoneVC.makeView(DISTANCE_FROM_FRAME, DISTANCE_FROM_FRAME);
        view.add(enemyZoneView);
        SubPhaseView subPhaseView = subPhaseVC.makeView(
                width - (ProgressPhaseButtonView.PROGRESS_BUTTON_WIDTH + PhaseView.PHASE_BUTTON_WIDTH), PhaseView.PHASE_BUTTON_HEIGHT);
        view.add(subPhaseView);
        view.setVisible(true);
        return view;
    }
    
    public String getCurrentSubPhase(){
        return myBoard.getCurrentSubPhase().toString();
    }
   
    public String getCurrentPhase(){
        return myBoard.getCurrentPhase().toString();
    }

    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }

    public void updatePhase() {
        myBoard.advancePhase();
        updateView();
    }
    
    public PlayerZoneViewController getCurrentPlayerZoneViewController(){
        return playerZoneVC;
    }
    
    public void updateView(){
        activeState.unsetActionable();
        phaseVC.updateView();
        phaseButtonController.updateView();
        playerZoneVC.updateView();
        encounterZoneVC.updateView();
        subPhaseVC.updateView();
        
        //TODO: UPDATE OTHER VIEWS
    }
    
    public Board getBoard(){
        return myBoard;
    }
    
    
}
