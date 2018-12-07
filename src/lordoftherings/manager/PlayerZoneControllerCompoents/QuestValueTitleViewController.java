//Copyright Amanda V. Harris 2018-present. All Rights Reserved.
package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.GameConfiguration;
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
    private GameConfiguration config;
    
    public QuestValueTitleViewController(PlayerZoneViewController zoneVC, GameConfiguration config){
        this.zoneVC = zoneVC;
        this.currentPhase = null;
        this.config = config;
    }
    
    public void getCurrentPhase(){
        currentPhase = zoneVC.getCurrentPhase();
    }
    
    public QuestValueTitleView makeView(int x, int y){
        titleView = new QuestValueTitleView(x, y, config);
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
