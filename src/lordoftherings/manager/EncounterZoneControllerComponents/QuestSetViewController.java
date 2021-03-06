//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.QuestSet;
import lordoftherings.gui.EncounterZoneComponents.QuestSetParentView;
import lordoftherings.gui.EncounterZoneComponents.QuestSetView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;

/**
 *
 * @author Amanda
 */
public class QuestSetViewController implements Focusable{
    private QuestSet questSet;
    private BoardActiveState bas;
    private QuestSetParentView parentView;
    private QuestSetView setView;
    private GameConfiguration config;
    
    public QuestSetViewController(QuestSet questSet, BoardActiveState bas, GameConfiguration config){
       this.questSet = questSet;
       this.bas= bas;
       this.config = config;
    }
    
    public QuestSetParentView makeView(int x, int y){
        parentView = new QuestSetParentView(x, y, config);
        setView = new QuestSetView(bas, this, 0, 0, config);
        parentView.add(setView);
        parentView.addMouseMotionListener(bas.createMouseFollower());
        if(questSet.getSizeOfSet()== 0){
            parentView.setVisible(false);
        }else{
           parentView.setVisible(true); 
        }
        return parentView;
    }
    
    public void updateView(){
        if(questSet.getSizeOfSet() == 0){
            parentView.setVisible(false);
            setView.setVisible(false);
        }
        parentView.revalidate();
        parentView.repaint();
    }

    @Override
    public String getViewingText() {
        if(questSet.getSizeOfSet() == 1){
            return "1 quest remains";
        }
        return questSet.getSizeOfSet() + " quests remain";
    }
    
}
