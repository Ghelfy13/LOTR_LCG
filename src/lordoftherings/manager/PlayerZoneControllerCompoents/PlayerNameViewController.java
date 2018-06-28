//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.gui.PlayerZoneComponents.PlayerNameView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Focusable;

/**
 *
 * @author Amanda
 */
public class PlayerNameViewController implements Focusable{
    
    private BoardActiveState bas;
    private String nameOfPlayer;
    private PlayerNameView view;
    
    public PlayerNameViewController(String name, BoardActiveState bas){
        this.bas = bas;
        this.nameOfPlayer = name;
    }
    
    public PlayerNameView makeView(int x, int y){
        view = new PlayerNameView(x, y, nameOfPlayer);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }

    @Override
    public String getViewingText() {
        return "";
    }
}
