//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController;
import lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController;
import java.awt.Point;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.NumOfRoundsTracker;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.gui.BoardView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import static lordoftherings.gui.GameManagerView.WINDOW_LENGTH;
import static lordoftherings.gui.GameManagerView.WINDOW_WIDTH;
import lordoftherings.gui.NumOfRoundsLabelView;
import lordoftherings.gui.NumOfRoundsView;
import lordoftherings.gui.PhaseView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;
import lordoftherings.gui.ProgressPhaseButtonView;
import lordoftherings.gui.SubPhaseView;
import lordoftherings.gui.VictoryPointsLabelView;
import lordoftherings.gui.VictoryPointsPileView;
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
    private GameManagerViewController gameManagerVC;
    private VictoryPointsPileViewController vpPileVC;
    private VictoryPointsLabelViewController vpLabelVC;
    private NumOfRoundsTracker numOfRounds;
    private NumOfRoundsLabelViewController numOfRoundsLVC;
    private NumOfRoundsViewController numOfRoundsVC;
    private GameConfiguration config;
    public static final int DISTANCE_FROM_FRAME = 10;
    public static final int DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE = 245;
    public int width = WINDOW_WIDTH;
    public int height = WINDOW_LENGTH;
    public static final int PLAYERZONE_Y_COORDINATE = 470;
    public static final int PHASEVIEW_X_COORDINATE = 2250;
    public static final int PROGRESS_BUTTON_X_VALUE = 2025;
    public static final int VPPILE_X_VALUE = 2185;
    public static final int VPPILE_Y_VALUE = 225 + DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE;
    public static final int VPLABEL_X_VALUE = 2140;
    public static final int VPLABEL_Y_VALUE = 445 + DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE;
    public static final int ROUNDS_LABEL_Y_VALUE = 225;
    public static final int ROUNDS_Y_VALUE = ROUNDS_LABEL_Y_VALUE + 30;
    public static final int SUBPHASE_Y_VALUE = 50;
    
    public BoardViewController(Board newBoard, GameManagerViewController managerVC, GameConfiguration config){
        this.config = config;
        this.myBoard = newBoard;
        this.phaseVC = new PhaseViewController(this, config);
        this.view = null;
        this.activeState = new BoardActiveState(managerVC, config);
        this.currentPhase = GamePhase.RESOURCE;
        this.encounterZoneVC = new EncounterZoneViewController(activeState, myBoard.getEncounterZone(), config);
        this.playerZoneVC = new PlayerZoneViewController(this, myBoard.getPlayerZoneAt(0), activeState, config);
        this.subPhaseVC = new SubPhaseViewController(this, config);
        this.gameManagerVC = managerVC;
        this.vpPileVC = new VictoryPointsPileViewController(this, activeState, config);
        this.vpLabelVC = new VictoryPointsLabelViewController(this, myBoard.getVPPile(), config);
        this.numOfRounds = newBoard.getNumOfRounds();
        this.numOfRoundsLVC = new NumOfRoundsLabelViewController(this, config);
        this.numOfRoundsVC = new NumOfRoundsViewController(this, numOfRounds, config);
        this.phaseButtonController = new ProgressPhaseButtonViewController(gameManagerVC, config);
    }
    
    public BoardView makeView(int x, int y){
        view = new BoardView(x, y, config);
        view.add(activeState.getFocusableText());
        view.add(activeState.getAvailableActions());
        view.addMouseMotionListener(activeState.createMouseFollower());
        PlayerZoneView playerView = playerZoneVC.makeView(DISTANCE_FROM_FRAME, PLAYERZONE_Y_COORDINATE);
        view.add(playerView);
        phaseVC = new PhaseViewController(this, config);
        PhaseView phaseView = phaseVC.makeView(PHASEVIEW_X_COORDINATE, y);
        view.add(phaseView);
        ProgressPhaseButtonView phaseButtonView = phaseButtonController.makeView(
                PROGRESS_BUTTON_X_VALUE, y);
        ProgressPhaseActionListener ppActionListener = new ProgressPhaseActionListener(gameManagerVC, this);
        phaseButtonView.addActionListener(ppActionListener);
        view.add(phaseButtonView);
        VictoryPointsPileView vpPileView = vpPileVC.makeView(VPPILE_X_VALUE, VPPILE_Y_VALUE);
        view.add(vpPileView);
        VictoryPointsLabelView vpLabelView = vpLabelVC.makeView(VPLABEL_X_VALUE, VPLABEL_Y_VALUE);
        view.add(vpLabelView);
        NumOfRoundsLabelView numOfRoundsLabelView = numOfRoundsLVC.makeView(VPPILE_X_VALUE,  
                ROUNDS_LABEL_Y_VALUE);
        NumOfRoundsView numOfRoundsView = numOfRoundsVC.makeView(VPPILE_X_VALUE, ROUNDS_Y_VALUE);
        view.add(numOfRoundsView);
        view.add(numOfRoundsLabelView);
        EncounterZoneView enemyZoneView = encounterZoneVC.makeView(DISTANCE_FROM_FRAME, DISTANCE_FROM_FRAME);
        view.add(enemyZoneView);
        SubPhaseView subPhaseView = subPhaseVC.makeView(PROGRESS_BUTTON_X_VALUE, SUBPHASE_Y_VALUE);
        view.add(subPhaseView);
        view.setVisible(true);
        return view;
    }
    
    public String getCurrentSubPhase(){
        return myBoard.getPhaseManagerGovenor().getCurrentSubPhase().toString();
    }
   
    public String getCurrentPhase(){
        return myBoard.getPhaseManagerGovenor().getCurrentPhase().toString();
    }

    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }

    public void updatePhase() {
        myBoard.getPhaseManagerGovenor().advancePhase();
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
        vpPileVC.updateView();
        vpLabelVC.updateView();
        numOfRoundsVC.updateView();
    }
    
    public Board getBoard(){
        return myBoard;
    }
    
    
}
