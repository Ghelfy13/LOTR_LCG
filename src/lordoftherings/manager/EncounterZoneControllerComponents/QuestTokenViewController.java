/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.QuestTokenView;

/**
 *
 * @author Amanda
 */
public class QuestTokenViewController {
    private QuestTokenView tokenView;
    private int tokenCount;
    private GameConfiguration config;
    
    public QuestTokenViewController(GameConfiguration config){
        tokenCount = 0;
        this.config = config;
    }
    
    public QuestTokenView makeView(int x, int y){
        tokenView = new QuestTokenView(x, y, tokenCount, config);
        tokenView.setVisible(true);
        return tokenView;
    }
    
    public void updateView(int numOfTokens){
        tokenView.setText("Tokens: " + numOfTokens);
        tokenView.revalidate();
        tokenView.repaint();
    }
}
