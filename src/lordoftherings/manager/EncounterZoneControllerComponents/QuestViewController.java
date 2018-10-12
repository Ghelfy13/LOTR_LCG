/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.deckcomponents.Quest;
import lordoftherings.gui.EncounterZoneComponents.QuestCardView;
import lordoftherings.gui.EncounterZoneComponents.QuestTokenView;
import lordoftherings.gui.EncounterZoneComponents.QuestView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class QuestViewController implements Focusable{
    private Quest currentQuest;
    private QuestCardViewController cardVC;
    private QuestTokenViewController tokenVC;
    private QuestView view;
    private QuestCardView cardView;
    private QuestTokenView tokenView;
    private BoardActiveState bas;
    
    public QuestViewController(Quest currentQuest, BoardActiveState bas){
        this.currentQuest = currentQuest;
        this.bas = bas;
        cardVC = new QuestCardViewController(currentQuest.getQuestCard(), bas);
        tokenVC = new QuestTokenViewController();
    }
    
    public QuestView makeView(int x, int y){
        view = new QuestView(x, y);
        cardView = cardVC.makeView();
        cardView.addMouseListener(new FocusableMouseListener(bas, this));
        cardView.addMouseMotionListener(bas.createMouseFollower());
        view.add(cardView);
        tokenView = tokenVC.makeView(0, HandCardView.CARD_WIDTH);
        view.add(tokenView);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(Quest newQuest){
        if(newQuest != currentQuest){
            cardVC.updateView(newQuest.getQuestCard());
            currentQuest = newQuest;
            tokenVC.updateView(0);
        }else{
            tokenVC.updateView(currentQuest.getNumOfTokens());
        }
        view.revalidate();
        view.repaint();
    }

    @Override
    public String getViewingText() {
        return currentQuest.getQuestCard().getTitle();
    }

   
}
