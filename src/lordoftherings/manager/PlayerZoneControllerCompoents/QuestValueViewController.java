//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.gui.PlayerZoneComponents.QuestValueView;
import lordoftherings.phasemanager.GamePhase;
import lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController;

/**
 *
 * @author Amanda
 */
public class QuestValueViewController {
    private int currentQuestValue;
    private PlayerZoneViewController zoneVC;
    private GamePhase currentPhase;
    private QuestValueView valueView;
    
    public QuestValueViewController(PlayerZoneViewController zoneVC){
        this.zoneVC = zoneVC;
        this.currentQuestValue = 0;
    }
    
    public QuestValueView makeView(int x, int y){
        valueView = new QuestValueView(x,y);
        valueView.setText("" +currentQuestValue);
        valueView.setVisible(false);
        return valueView;
    }
    
    public void updateView(){
        currentPhase = zoneVC.getCurrentPhase();
        if(currentPhase == GamePhase.QUEST){
            currentQuestValue = zoneVC.getQuestingTotal();
            valueView.setText("" + currentQuestValue);
            valueView.setVisible(true);
            valueView.revalidate();
            valueView.repaint();
        }else{
            valueView.setVisible(false);
        }
    }
    
}
