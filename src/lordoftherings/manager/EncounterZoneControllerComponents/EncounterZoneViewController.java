//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.gui.EncounterZoneComponents.EncounterDeckParentView;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaView;
import lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class EncounterZoneViewController {
    private EncounterDeckViewController enemyDeckVC;
    private EncounterDiscardPileViewController enemyDPileVC;
    private QuestSetViewController questSetVC;
    private EncounterZone encounterZone;
    private StagingAreaViewController stagingVC;
    private EncounterZoneView view;
    private BoardActiveState bas;
    private StagingAreaThreatViewController threatVC;
    private StagingAreaThreatTitleViewController threatTitleVC;
    public static final int DISTANCE_FROM_FRAME = 10;
    public static final int DISTANCE_BT_DECK_AND_STAGE = 35;
    
    
    public EncounterZoneViewController(BoardActiveState boardAS, EncounterZone zone){
        this.encounterZone = zone;
        this.bas = boardAS;
        this.enemyDeckVC = new EncounterDeckViewController(encounterZone.getEncounterDeck(), this);
        this.enemyDPileVC = new EncounterDiscardPileViewController(this, bas, encounterZone.getEnemyDiscardPile());
        this.questSetVC = new QuestSetViewController();
        this.stagingVC = new StagingAreaViewController(boardAS, encounterZone.getStagingArea());
        this.threatTitleVC = new StagingAreaThreatTitleViewController(zone);
        this.threatVC = new StagingAreaThreatViewController(zone);
    }
    
    public EncounterZoneView makeView(int x, int y){
        view = new EncounterZoneView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        EncounterDeckParentView deckView = enemyDeckVC.makeView(
                bas.createMouseFollower(), PlayerZoneViewController.DECK_X, DISTANCE_FROM_FRAME);
        EncounterDiscardPileView discardView = enemyDPileVC.makeView(0, DISTANCE_FROM_FRAME);
        StagingAreaView stageView = stagingVC.makeView(EncounterDeckParentView.CARD_WIDTH + DISTANCE_BT_DECK_AND_STAGE + 190, 0);
        StagingAreaThreatTitleView threatTitleView = threatTitleVC.makeView(1825, 75);
        StagingAreaThreatView threatView = threatVC.makeView(1825, 125);
        view.add(threatTitleView);
        view.add(threatView);
        view.add(deckView);
        view.add(stageView);
        view.add(discardView);
        view.setVisible(true);
        return view;
    }
    
    public BoardActiveState getBoardActiveState(){
        return bas;
    }
    
    public void updateView(){
        enemyDeckVC.updateView();
        stagingVC.updateView();
        threatTitleVC.updateView();
        threatVC.updateView();
        //TODO
        enemyDPileVC.updateView();
        //questSetVC.updateView();
        
    }
}
