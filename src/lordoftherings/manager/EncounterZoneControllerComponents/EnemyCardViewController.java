//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.EncounterZoneControllerComponents;

import lordoftherings.GameConfiguration;
import lordoftherings.cards.EnemyCard;
import lordoftherings.gui.EncounterZoneComponents.EnemyCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class EnemyCardViewController{
    private EnemyCard card;
    private EnemyCardView view;
    private String enemyInfo;
    private BoardActiveState bas;
    private GameConfiguration config;
    
    public EnemyCardViewController(EnemyCard card, BoardActiveState bas, GameConfiguration config){
        this.card = card;
        enemyInfo = card.identify();
        this.bas = bas;
        this.config = config;
    }
    
    public BoardActiveState getBAS(){
        return bas;
    }
    
    public EnemyCardView makeView(int x, int y){
        view = new EnemyCardView(enemyInfo, x, y, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        view.setVisible(true);
        return view;
    }
    
    public void updateView(int x, int y){
        view.setLocation(config.scale(x), config.scale(y));
        view.setVisible(true);
        view.revalidate();
        view.repaint();
    }
    
    public EnemyCardView getView(){
        return view;
    }

}
