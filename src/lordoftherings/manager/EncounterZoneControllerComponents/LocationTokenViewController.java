//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.gui.EncounterZoneComponents.LocationTokenView;

/**
 *
 * @author Amanda
 */
public class LocationTokenViewController {
    private LocationTokenView tokenView;
    private int tokenCount;
    
    public LocationTokenViewController(){
        tokenCount = 0;
    }
    
    public LocationTokenView makeView(int x, int y){
        tokenView = new LocationTokenView(x, y, tokenCount);
        tokenView.setVisible(true);
        return tokenView;
    }
    
    public void updateView(int numOfTokens){
        tokenView.setText("Tokens: " + numOfTokens);
    }
}
