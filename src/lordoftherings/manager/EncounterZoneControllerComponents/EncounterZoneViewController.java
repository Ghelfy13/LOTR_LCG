//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import static lordoftherings.GameConfiguration.scale;
import lordoftherings.deckcomponents.Quest;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.gui.EncounterZoneComponents.EncounterDeckParentView;
import lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.EncounterZoneComponents.QuestDiscardPileView;
import lordoftherings.gui.EncounterZoneComponents.QuestSetParentView;
import lordoftherings.gui.EncounterZoneComponents.QuestView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatTitleView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaThreatView;
import lordoftherings.gui.EncounterZoneComponents.StagingAreaView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
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
    private QuestViewController questVC;
    private QuestDiscardPileViewController questDPileVC;
    private EncounterZone encounterZone;
    private StagingAreaViewController stagingVC;
    private EncounterZoneView view;
    private BoardActiveState bas;
    private StagingAreaThreatViewController threatVC;
    private StagingAreaThreatTitleViewController threatTitleVC;
    public static final int DISTANCE_FROM_FRAME = 10;
    public static final int DISTANCE_BT_DECK_AND_STAGE = 10;
    public static final int Y_VALUE_FOR_STAGING_AREA = 144 +
            4*DISTANCE_BT_DECK_AND_STAGE;
    public static final int X_VALUE_FOR_STAGING_AREA = 334 +
            DISTANCE_BT_DECK_AND_STAGE;
    public static final int QUEST_SET_X_VALUE = 200 +
                4*DISTANCE_BT_DECK_AND_STAGE;
    public static final int THREAT_X_VALUE = 1800;
    public static final int THREAT_Y_VALUE = 50;
    public static final int QUEST_X_VALUE = 400 + 8*DISTANCE_BT_DECK_AND_STAGE;
    public static final int DECK_X = 180;
    
    
    public EncounterZoneViewController(BoardActiveState boardAS, EncounterZone zone){
        this.encounterZone = zone;
        this.bas = boardAS;
        this.enemyDeckVC = new EncounterDeckViewController(encounterZone.getEncounterDeck(), this);
        this.enemyDPileVC = new EncounterDiscardPileViewController(this, bas, encounterZone.getEnemyDiscardPile());
        this.questSetVC = new QuestSetViewController(zone.getQuestSet(), bas);
        this.questVC = new QuestViewController(encounterZone, bas);
        this.stagingVC = new StagingAreaViewController(boardAS, encounterZone.getStagingArea());
        this.threatTitleVC = new StagingAreaThreatTitleViewController(zone);
        this.threatVC = new StagingAreaThreatViewController(zone);
        this.questDPileVC = new QuestDiscardPileViewController(this, bas, encounterZone.getQuestDiscardPile());
    }
    
    public EncounterZoneView makeView(int x, int y){
        view = new EncounterZoneView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        EncounterDeckParentView deckView = enemyDeckVC.makeView(
                bas.createMouseFollower(), DECK_X, 
                Y_VALUE_FOR_STAGING_AREA);
        EncounterDiscardPileView discardView = enemyDPileVC.makeView(0, 
                Y_VALUE_FOR_STAGING_AREA);
        StagingAreaView stageView = stagingVC.makeView(X_VALUE_FOR_STAGING_AREA,
                Y_VALUE_FOR_STAGING_AREA);
        StagingAreaThreatTitleView threatTitleView = threatTitleVC.makeView(THREAT_X_VALUE, 0);
        StagingAreaThreatView threatView = threatVC.makeView(THREAT_X_VALUE, THREAT_Y_VALUE);
        QuestDiscardPileView questDPView = questDPileVC.makeView(0,DISTANCE_FROM_FRAME);
        QuestSetParentView setView = questSetVC.makeView(QUEST_SET_X_VALUE,DISTANCE_FROM_FRAME);
        QuestView questView = questVC.makeView(QUEST_X_VALUE, DISTANCE_FROM_FRAME);
        view.add(questDPView);
        view.add(questView);
        view.add(setView);
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
        enemyDPileVC.updateView();
        questSetVC.updateView();
        questVC.updateView(encounterZone.getActiveQuest());
        questDPileVC.updateView();
        
    }
}
