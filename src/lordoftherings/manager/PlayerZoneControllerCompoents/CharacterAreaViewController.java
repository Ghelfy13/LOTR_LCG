//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import lordoftherings.boardcomponents.CharacterArea;
import lordoftherings.gui.PlayerZoneComponents.AllyZoneView;
import lordoftherings.gui.PlayerZoneComponents.CharacterAreaView;
import lordoftherings.gui.PlayerZoneComponents.HeroZoneView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import javax.swing.border.CompoundBorder;
import lordoftherings.GameConfiguration;

/**
 *
 * @author Amanda
 */
public class CharacterAreaViewController {
    private HeroZoneViewController heroZoneVC;
    private AllyZoneViewController allyZoneVC;
    private CharacterArea charZone;
    private PlayerZoneViewController playerZoneVC;
    private BoardActiveState bas;
    private GameConfiguration config;
    public static Border COMMIT_BORDER = BorderFactory.
            createMatteBorder(5, 5, 5, 5, Color.cyan);
    public static CompoundBorder COMMIT_ACTIVE_BORDER = new CompoundBorder
        (BoardActiveState.ACTIVE_BORDER, COMMIT_BORDER);
    
    public CharacterAreaViewController(PlayerZoneViewController playerZoneVC, 
            CharacterArea charZone, BoardActiveState bas, GameConfiguration config){
        this.playerZoneVC = playerZoneVC;
        this.charZone = charZone;
        this.heroZoneVC = new HeroZoneViewController(this, charZone.getHeroArea(), 
                bas, config);
        this.allyZoneVC = new AllyZoneViewController(this, charZone.getAllyArea(), 
                bas, config);
        this.bas = bas;
        this.config = config;
    }
    
    public CharacterAreaView makeView(int x, int y){
        CharacterAreaView charView = new CharacterAreaView(x, y, config);
        charView.addMouseMotionListener(bas.createMouseFollower());
        HeroZoneView heroView = heroZoneVC.makeView(0, 0);
        AllyZoneView allyView = allyZoneVC.makeView(heroView.getLengthOfHeroZone(), 0);
        charView.add(heroView);
        charView.add(allyView);
        charView.setVisible(true);
        return charView;
    }

    public void updateView(){
        heroZoneVC.updateView();
        allyZoneVC.updateView();
    }

    
}