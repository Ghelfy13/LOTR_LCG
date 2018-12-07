//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.characters.Hero;
import lordoftherings.gui.query_components.QueryHeroCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class QueryHeroCardViewController {
    private Hero myHero;
    private String heroInfo;
    private QueryHeroCardView cardView;
    private static final int CARD_HEIGHT = 200;
    private static final int CARD_WIDTH = 144;
    private CharacterQueryActiveState charQAS;
    private GameConfiguration config;
       
    public QueryHeroCardViewController(Hero myHero, 
            CharacterQueryActiveState charQAS,
            GameConfiguration config){
        this.myHero = myHero;
        this.heroInfo = myHero.getInfo();
        this.charQAS = charQAS;
        this.config = config;
    }
    
    public QueryHeroCardView makeView(){
        cardView = new QueryHeroCardView(heroInfo,myHero.isExhausted(), config);
        cardView.addMouseMotionListener(charQAS.createMouseFollower());
        cardView.setEditable(false);
        cardView.setVisible(true);
        return cardView;        
    }
    
    public QueryHeroCardView updateView(boolean isSelected){
        if(myHero.isExhausted()){
            cardView.setBounds(0, config.scale(CARD_HEIGHT - CARD_WIDTH),
                    config.scale(CARD_HEIGHT), config.scale(CARD_WIDTH));
        }else if(!myHero.isExhausted()){
            cardView.setBounds(0, 0, config.scale(CARD_WIDTH), 
                    config.scale(CARD_HEIGHT));
        }if(isSelected){
            cardView.setBorder(BoardActiveState.ACTIVE_BORDER);
        }else{
            cardView.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        cardView.revalidate();
        cardView.repaint();
        return cardView;
    }
    
}
