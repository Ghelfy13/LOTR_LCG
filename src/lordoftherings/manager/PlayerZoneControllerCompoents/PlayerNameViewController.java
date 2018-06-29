//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.boardcomponents.PlayerName;
import lordoftherings.gui.PlayerZoneComponents.PlayerNameView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;

/**
 *
 * @author Amanda
 */
public class PlayerNameViewController implements Focusable{
    
    private BoardActiveState bas;
    private PlayerNameView view;
    private String name;
    
    public PlayerNameViewController(String name, BoardActiveState bas){
        this.bas = bas;
        this.name= name;
    }
    
    public PlayerNameView makeView(int x, int y){
        view = new PlayerNameView(x, y, name);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }

    @Override
    public String getViewingText() {
        return "";
    }
}
