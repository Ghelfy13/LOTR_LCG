//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.PhaseManager.GamePhase;
import lordoftherings.boardcomponents.PlayerZone;
import lordoftherings.gui.PlayerZoneComponents.CharacterAreaView;
import lordoftherings.gui.PlayerZoneComponents.DeckViewParent;
import lordoftherings.gui.PlayerZoneComponents.DiscardPileView;
import lordoftherings.gui.PlayerZoneComponents.EngagementAreaView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.gui.PlayerZoneComponents.HandView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueTitleView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueView;
import lordoftherings.gui.PlayerZoneComponents.QuestValueViewController;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialTitleView;
import lordoftherings.gui.PlayerZoneComponents.ThreatDialView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.BoardControllerComponents.BoardViewController;

/**
 *
 * @author Amanda
 */
public class PlayerZoneViewController {
    public static final int DECK_X = 210;
    public static final int DECK_Y = 30;
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
    private DiscardPileViewController dpvc; 
    
    public PlayerZoneViewController(BoardViewController bvc, PlayerZone pz, BoardActiveState bas){
        this.bvc = bvc;
        this.playerZone = pz;
        this.bas = bas;
        handvc = new HandViewController(this, pz.getHand(), bas);
        charAreaVC = new CharacterAreaViewController(this, pz.getCharZone(), bas);
        deckvc = new DeckViewController(this, pz.getDeck(), bas);
        this.engageAreaVC = new EngagementAreaViewController(bas, pz.getEngagementArea(), bvc);
        this.threatDialVC = new ThreatDialViewController(pz);
        this.threatTitleVC = new ThreatDialTitleViewController(pz);
        this.questTitleVC = new QuestValueTitleViewController(this);
        this.questValueVC = new QuestValueViewController(this);
        this.dpvc = new DiscardPileViewController(pz.getDPile(), this, bas);
    }
    
    public PlayerZoneView makeView(int x, int y){
        playerView = new PlayerZoneView(x,y);
        playerView.addMouseMotionListener(bas.createMouseFollower());
        DeckViewParent myDeck = deckvc.makeView(DECK_X, 610);
        playerView.add(myDeck);
        HandView myHand = handvc.makeView(DECK_X + HandCardView.CARD_WIDTH + 20, 610);
        playerView.add(myHand);
        CharacterAreaView charView = charAreaVC.makeView(
                DECK_X + HandCardView.CARD_WIDTH + 20, 305);
        playerView.add(charView);
        EngagementAreaView engageAreaView = engageAreaVC.makeView(DECK_X + HandCardView.CARD_WIDTH + 20, 0);
        playerView.add(engageAreaView);
        ThreatDialTitleView threatTitleView = threatTitleVC.makeView(1800, 800);
        playerView.add(threatTitleView);
        ThreatDialView threatDialView = threatDialVC.makeView(1800,850);
        playerView.add(threatDialView);
        QuestValueTitleView questTitleView = questTitleVC.makeView(1800, 650);
        playerView.add(questTitleView);
        QuestValueView questValue = questValueVC.makeView(1800, 700);
        playerView.add(questValue);
        DiscardPileView dPileView = dpvc.makeView(0, 610);
        playerView.add(dPileView);
        playerView.setVisible(true);
        return playerView;
    }
    
    public PlayerZone getPlayerZone(){
        return playerZone;
    }
    
    public GamePhase getCurrentPhase(){
        return bvc.getBoard().getCurrentPhase();
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
        dpvc.updateView();
    }

}
