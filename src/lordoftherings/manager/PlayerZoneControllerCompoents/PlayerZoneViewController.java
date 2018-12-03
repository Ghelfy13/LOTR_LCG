//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import static lordoftherings.GameConfiguration.scale;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.CharacterAreaView;
import lordoftherings.gui.PlayerZoneComponents.DeckViewParent;
import lordoftherings.gui.PlayerZoneComponents.DiscardPileView;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
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
    private HandViewController handvc;
    private PlayerZoneView playerView;
    private CharacterAreaViewController charAreaVC;
    private DeckViewController deckvc;
    private BoardActiveState bas;
    private EngagementAreaViewController engageAreaVC;
    private ThreatDialViewController threatDialVC;
    private ThreatDialTitleViewController threatTitleVC;
    private QuestValueViewController questValueVC;
    private QuestValueTitleViewController questTitleVC;
    private DiscardPileViewController discardPileVC; 
    private PlayerNameViewController playerNameVC;
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
    
    
    public PlayerZoneViewController(BoardViewController bvc, PlayerZone pz, BoardActiveState bas){
        this.bvc = bvc;
        this.playerZone = pz;
        this.bas = bas;
        handvc = new HandViewController(this, pz.getHand(), bas);
        charAreaVC = new CharacterAreaViewController(this, pz.getCharZone(), bas);
        deckvc = new DeckViewController(this, pz.getDeck(), bas);
        this.engageAreaVC = new EngagementAreaViewController(bas, pz.getEngagementArea());
        this.threatDialVC = new ThreatDialViewController(pz);
        this.threatTitleVC = new ThreatDialTitleViewController(pz);
        this.questTitleVC = new QuestValueTitleViewController(this);
        this.questValueVC = new QuestValueViewController(this);
        this.playerNameVC = new PlayerNameViewController(pz.getPlayerName(), bas);//TODO actually feed in player's desired name
        this.discardPileVC = new DiscardPileViewController(pz.getDPile(), this, bas);
    }
    
    public PlayerZoneView makeView(int x, int y){
        playerView = new PlayerZoneView(x,y);
        playerView.addMouseMotionListener(bas.createMouseFollower());
        DeckViewParent myDeck = deckvc.makeView(DECK_X, Y_HAND_VALUE);
        playerView.add(myDeck);
        PlayerNameView nameView = playerNameVC.makeView(NAME_X, NAME_Y);
        playerView.add(nameView);
        HandView myHand = handvc.makeView(HAND_X, Y_HAND_VALUE);
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
        handvc.updateView();
        charAreaVC.updateView();
        deckvc.updateView();
        engageAreaVC.updateView();
        threatDialVC.updateView();
        threatTitleVC.updateView();
        questTitleVC.updateView();
        questValueVC.updateView();
        discardPileVC.updateView();
    }

}
