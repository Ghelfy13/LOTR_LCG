//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import lordoftherings.characters.Hero;
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
    private static final int CARD_HEIGHT = 250;
    private static final int CARD_WIDTH = 180;
    
    public HeroCardViewController(Hero myHero, BoardActiveState bas){
        this.myHero = myHero;
        this.heroInfo = myHero.getInfo();
        this.bas = bas;
        
    }
    
    public HeroCardView makeView(int xValue, int yValue){
        view = new HeroCardView(heroInfo, xValue, yValue);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setEditable(false);
        return view;
    }
    
    public HeroCardView updateView(int x, int y, boolean isExhausted, boolean isCommitted){
        if(isExhausted){
            view.setBounds(x, y + CARD_HEIGHT - CARD_WIDTH, CARD_HEIGHT, CARD_WIDTH);
        }else if(!isExhausted){
            view.setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
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
