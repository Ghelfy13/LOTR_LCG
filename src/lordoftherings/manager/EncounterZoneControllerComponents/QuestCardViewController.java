//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.deckcomponents.Quest;
import lordoftherings.cards.QuestCard;
import lordoftherings.gui.EncounterZoneComponents.QuestCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class QuestCardViewController {
    private QuestCardView cardView;
    private BoardActiveState bas;
    private QuestCard currentQuest;
    
    public QuestCardViewController(QuestCard currentQuest, BoardActiveState bas){
        this.bas = bas;
        this.currentQuest = currentQuest;
    }
    
    public QuestCardView makeView(QuestCard quest){
        cardView = new QuestCardView(quest.getModel().identify(), 0, 0);
        cardView.setVisible(true);
        return cardView;
    }
    
    public void updateView(QuestCard newQuest){
        if(newQuest == null){
            cardView.setVisible(false);
        }else{
            cardView.removeAll();
            cardView = new QuestCardView(newQuest.getModel().identify(), 0, 0);
            cardView.setVisible(true);
        }
        cardView.revalidate();
        cardView.repaint();
    }
    
}
