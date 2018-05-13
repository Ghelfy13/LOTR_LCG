/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.gui.EncounterZoneComponents.QuestTokenView;

/**
 *
 * @author Amanda
 */
public class QuestTokenViewController {
    private QuestTokenView tokenView;
    private int tokenCount;
    
    public QuestTokenViewController(){
        tokenCount = 0;
    }
    
    public QuestTokenView makeView(int x, int y){
        tokenView = new QuestTokenView(x, y, tokenCount);
        tokenView.setVisible(true);
        return tokenView;
    }
    
    public void updateView(int numOfTokens){
        tokenView.setText("Tokens: " + numOfTokens);
        tokenView.revalidate();
        tokenView.repaint();
    }
}
