//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.TokenView;

/**
 *
 * @author Amanda
 */
public class TokenViewController {
    private TokenView tokenView;
    private int tokenCount;
    private GameConfiguration config;
    
    public TokenViewController(GameConfiguration config){
        tokenCount = 0;
        this.config = config;
    }
    
    public TokenView makeView(int x, int y){
        tokenView = new TokenView(x, y, tokenCount, config);
        tokenView.setVisible(true);
        return tokenView;
    }
    
    public void updateView(int numOfTokens){
        tokenView.setText("Tokens: " + numOfTokens);
        tokenView.revalidate();
        tokenView.repaint();
    }
}
