//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

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
    private QuestCard currentQuest;
    private BoardActiveState bas;
    
    public QuestCardViewController(QuestCard newQuest, BoardActiveState bas){
        this.bas = bas;
        this.currentQuest = newQuest;
    }
    
    public QuestCardView makeView(){
        cardView = new QuestCardView(currentQuest.getModel().identify(), 0, 0);
        cardView.setVisible(true);
        return cardView;
    }
    
    public void updateView(String newInfo){
        cardView.setText(newInfo);
        cardView.revalidate();
        cardView.repaint();
    }
    
}
