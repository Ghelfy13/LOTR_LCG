//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.gui.EncounterZoneComponents.TokenView;

/**
 *
 * @author Amanda
 */
public class TokenViewController {
    private TokenView tokenView;
    private int tokenCount;
    
    public TokenViewController(){
        tokenCount = 0;
    }
    
    public TokenView makeView(int x, int y){
        tokenView = new TokenView(x, y, tokenCount);
        tokenView.setVisible(true);
        return tokenView;
    }
    
    public void updateView(int numOfTokens){
        tokenView.setText("Tokens: " + numOfTokens);
        tokenView.revalidate();
        tokenView.repaint();
    }
}
