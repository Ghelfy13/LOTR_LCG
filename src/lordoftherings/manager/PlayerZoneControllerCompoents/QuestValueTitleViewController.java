//Copyright Amanda V. Harris 2018-present. All Rights Reserved.
package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.phasemanager.GamePhase;
import lordoftherings.gui.PlayerZoneComponents.QuestValueTitleView;

/**
 *
 * @author Amanda
 */
public class QuestValueTitleViewController {
    private PlayerZoneViewController zoneVC;
    private GamePhase currentPhase;
    private QuestValueTitleView titleView;
    
    public QuestValueTitleViewController(PlayerZoneViewController zoneVC){
        this.zoneVC = zoneVC;
        this.currentPhase = null;
    }
    
    public void getCurrentPhase(){
        currentPhase = zoneVC.getCurrentPhase();
    }
    
    public QuestValueTitleView makeView(int x, int y){
        titleView = new QuestValueTitleView(x, y);
        titleView.setVisible(false);
        return titleView;
    }
    
    public void updateView(){
        getCurrentPhase();
        if(currentPhase == GamePhase.QUEST){
            titleView.setVisible(true);
            titleView.revalidate();
            titleView.repaint();
        }else{
            titleView.setVisible(false);
        }
    }
}
