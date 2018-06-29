//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.matcher;

import lordoftherings.boardcomponents.Board;
import lordoftherings.boardcomponents.PlayerZone;

/**
 *
 * @author Amanda
 */
public class PlayerZoneMatcher implements Matcher<PlayerZone>{

    @Override
    public boolean matches(PlayerZone element) {
        for(int i = 0; i < Board.playerZones.length; ++i){
            if(Board.playerZones[i] == element){
                return true;
            }
        }
        return false;
    }
    
    
}
