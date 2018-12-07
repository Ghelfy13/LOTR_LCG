//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.GameConfiguration;
import lordoftherings.characters.Hero;
import static lordoftherings.gui.PlayerZoneComponents.HandCardView.CARD_HEIGHT;
import static lordoftherings.gui.PlayerZoneComponents.HandCardView.CARD_WIDTH;
import lordoftherings.gui.PlayerZoneComponents.HeroCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class HeroCardViewController {
    private Hero myHero;
    private String heroInfo;
    private BoardActiveState bas;
    private HeroCardView view;
    private GameConfiguration config;
    
    public HeroCardViewController(Hero myHero, BoardActiveState bas, GameConfiguration config){
        this.myHero = myHero;
        this.heroInfo = myHero.getInfo();
        this.bas = bas;
        this.config = config;
    }
    
    public HeroCardView makeView(int x, int y){
        view = new HeroCardView(heroInfo, x, y, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setEditable(false);
        return view;
    }
    
    public HeroCardView updateView(int x, int y, boolean isExhausted, boolean isCommitted){
        if(isExhausted){
            view.setBounds(config.scale(x), config.scale(y + CARD_HEIGHT - CARD_WIDTH), 
                    config.scale(CARD_HEIGHT), config.scale(CARD_WIDTH));
        }else if(!isExhausted){
            view.setBounds(config.scale(x), config.scale(y), 
                    config.scale(CARD_WIDTH), config.scale(CARD_HEIGHT));
        }if(isCommitted){
            view.setBorder(CharacterAreaViewController.COMMIT_BORDER);
        }else if(!isCommitted){
            view.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        view.revalidate();
        view.repaint();
        return view;
    }
    
}
