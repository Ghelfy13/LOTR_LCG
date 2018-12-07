//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.GameConfiguration;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.CharacterAreaView;
import lordoftherings.gui.PlayerZoneComponents.DeckViewParent;
import lordoftherings.gui.PlayerZoneComponents.DiscardPileView;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;
import lordoftherings.gui.PlayerZoneComponents.HandView;
import lordoftherings.gui.PlayerZoneComponents.PlayerNameView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueTitleView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialTitleView;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.BoardControllerComponents.BoardViewController;

/**
 *
 * @author Amanda
 */
public class PlayerZoneViewController {
    
    private BoardViewController bvc;
    private PlayerZone playerZone;
    private HandViewController handVC;
    private PlayerZoneView playerView;
    private CharacterAreaViewController charAreaVC;
    private DeckViewController deckVC;
    private BoardActiveState bas;
    private EngagementAreaViewController engageAreaVC;
    private ThreatDialViewController threatDialVC;
    private ThreatDialTitleViewController threatTitleVC;
    private QuestValueViewController questValueVC;
    private QuestValueTitleViewController questTitleVC;
    private DiscardPileViewController discardPileVC; 
    private PlayerNameViewController playerNameVC;
    private GameConfiguration config;
    public static final int DECK_X = 180;
    public static final int Y_HAND_VALUE = 495;
    public static final int DISTANCE_BT_FIELDS = 50;
    public static final int CHAR_AREA_X = DECK_X + 164;
    public static final int CHAR_AREA_Y = 200 + DISTANCE_BT_FIELDS;
    public static final int NAME_X = 60;
    public static final int NAME_Y = Y_HAND_VALUE - 100;
    public static final int HAND_X = DECK_X + 164;
    public static final int THREAT_X = 1800;
    public static final int THREAT_Y = Y_HAND_VALUE + 100;
    public static final int THREAT_DIAL_Y = THREAT_Y + 50;
    public static final int QUEST_Y = Y_HAND_VALUE - 50;
    public static final int DISCARD_Y = Y_HAND_VALUE - 10;
    
    
    public PlayerZoneViewController(BoardViewController bvc, PlayerZone pz, 
            BoardActiveState bas, GameConfiguration config){
        this.bvc = bvc;
        this.playerZone = pz;
        this.bas = bas;
        this.config = config;
        this.handVC = new HandViewController(this, pz.getHand(), bas, config);
        this.charAreaVC = new CharacterAreaViewController(this, pz.getCharZone(), 
                bas, config);
        this.deckVC = new DeckViewController(this, pz.getDeck(), bas, config);
        this.engageAreaVC = new EngagementAreaViewController(bas,
                pz.getEngagementArea(), config);
        this.threatDialVC = new ThreatDialViewController(pz, config);
        this.threatTitleVC = new ThreatDialTitleViewController(pz, config);
        this.questTitleVC = new QuestValueTitleViewController(this, config);
        this.questValueVC = new QuestValueViewController(this, config);
        this.playerNameVC = new PlayerNameViewController(pz.getPlayerName(), bas, config);
        this.discardPileVC = new DiscardPileViewController(pz.getDPile(), this, bas, config);
    }
    
    public PlayerZoneView makeView(int x, int y){
        playerView = new PlayerZoneView(x, y, config);
        playerView.addMouseMotionListener(bas.createMouseFollower());
        DeckViewParent myDeck = deckVC.makeView(DECK_X, Y_HAND_VALUE);
        playerView.add(myDeck);
        PlayerNameView nameView = playerNameVC.makeView(NAME_X, NAME_Y);
        playerView.add(nameView);
        HandView myHand = handVC.makeView(HAND_X, Y_HAND_VALUE);
        playerView.add(myHand);
        CharacterAreaView charView = charAreaVC.makeView(CHAR_AREA_X, CHAR_AREA_Y);
        playerView.add(charView);
        EngagementAreaView engageAreaView = engageAreaVC.makeView(HAND_X, 0);
        playerView.add(engageAreaView);
        ThreatDialTitleView threatTitleView = threatTitleVC.makeView(THREAT_X, THREAT_Y);
        playerView.add(threatTitleView);
        ThreatDialView threatDialView = threatDialVC.makeView(THREAT_X, THREAT_DIAL_Y);
        playerView.add(threatDialView);
        QuestValueTitleView questTitleView = questTitleVC.makeView(THREAT_X, Y_HAND_VALUE);
        playerView.add(questTitleView);
        QuestValueView questValue = questValueVC.makeView(THREAT_X, QUEST_Y);
        playerView.add(questValue);
        DiscardPileView dPileView = discardPileVC.makeView(0, DISCARD_Y);
        playerView.add(dPileView);
        playerView.setVisible(true);
        return playerView;
    }
    
    public PlayerZone getPlayerZone(){
        return playerZone;
    }
    
    public GamePhase getCurrentPhase(){
        return bvc.getBoard().getPhaseManagerGovenor().getCurrentPhase();
    }
    
    public int getQuestingTotal(){
        return playerZone.getCurrentQuestingTotal();
    }
    
    public void updateView() {
        handVC.updateView();
        charAreaVC.updateView();
        deckVC.updateView();
        engageAreaVC.updateView();
        threatDialVC.updateView();
        threatTitleVC.updateView();
        questTitleVC.updateView();
        questValueVC.updateView();
        discardPileVC.updateView();
    }

}
