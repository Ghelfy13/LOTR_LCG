//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.GameConfiguration;
import lordoftherings.cards.AllyCard;
import lordoftherings.characters.Ally;
import lordoftherings.gui.query_components.QueryAllyCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class QueryAllyCardViewController {
    private AllyCard card;
    private QueryAllyViewController allyVC;
    private QueryAllyCardView view;
    private CharacterQueryActiveState charQAS;
    private GameConfiguration config;
    
    public QueryAllyCardViewController(Ally currentAlly, 
            QueryAllyViewController allyVC,
            CharacterQueryActiveState charQAS,
            GameConfiguration config){
        this.card = currentAlly.getCard();
        this.allyVC = allyVC;
        view = null;
        this.charQAS = charQAS;
        this.config = config;
    }
    
    public QueryAllyCardView makeView(boolean isExhausted){
        view = new QueryAllyCardView(card.getIdentity(), isExhausted, config);
        view.addMouseMotionListener(charQAS.createMouseFollower());
        view.setVisible(true);
        return view;
    }

    public QueryAllyCardView updateView(boolean selected) {
        if(selected){
            view.setBorder(BoardActiveState.ACTIVE_BORDER);
        }else{
            view.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        return view;
    }
}
