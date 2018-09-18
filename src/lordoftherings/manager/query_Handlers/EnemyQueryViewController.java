//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.boardcomponents.EnemyArea;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.query_components.EnemyQueryEnemyAreaView;
import lordoftherings.gui.query_components.EnemyQueryEngagedEnemyAreaView;
import lordoftherings.gui.query_components.EnemyQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.manager.actionComponents.GlobalViewController;
import lordoftherings.transaction_managers.EnemyQueryHandle;

/**
 *
 * @author Amanda
 */
public class EnemyQueryViewController extends QueryViewController<Enemy>
    implements CancellableQueryViewController, GlobalViewController{
    
    private EnemyQueryEnemyAreaViewController enemyAreaVC;
    private EnemyQueryEngagedEnemyAreaViewController engagedEnemyAreaVC;
    private EnemyQueryActiveState enemyQAS;
    private EnemyQueryView view;
    private EngagedEnemyArea engagedArea;
    private EncounterZone encounterZone;
    
    public EnemyQueryViewController(GameManagerViewController gameMVC, EnemyQueryHandle handle) {
        super(gameMVC, handle);
        this.enemyQAS = new EnemyQueryActiveState(this);
        this.enemyAreaVC = new EnemyQueryEnemyAreaViewController(this, 
            gameMVC.getBoard().getEncounterZone(),
            enemyQAS);
        this.engagedEnemyAreaVC = new EnemyQueryEngagedEnemyAreaViewController(this,
            gameMVC.getBoard().getCurrentPlayerZone().getEngagementArea(), enemyQAS);
        this.engagedArea = gameMVC.getBoard().getCurrentPlayerZone().getEngagementArea();
        this.encounterZone = gameMVC.getBoard().getEncounterZone();
    }

    @Override
    public EnemyQueryView makeView(String description) {
        view = new EnemyQueryView();
        view.add(enemyQAS.getFocusableText());
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(1995, 0, description);//Just copied from CharQueryVC
        view.add(messageView);
        EnemyQueryEnemyAreaView enemyAreaView = enemyAreaVC.makeView(100, 200);//TODO: FIND NECESSARY DIMENSIONS
        EnemyQueryEngagedEnemyAreaView engagedEnemyAreaView = engagedEnemyAreaVC.makeView(100, 200); //TODO: FIND NECESSARY DIMENSIONS
        view.add(enemyAreaView);
        view.add(engagedEnemyAreaView);
        view.setVisible(true);
        return view;
    }

    @Override
    public void updateView() {
        messageVC.updateView();
        engagedEnemyAreaVC.updateView();
        enemyAreaVC.updateView();
    }

    @Override
    public EnemyQueryView getView() {
        return view;
    }

    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }
    
    public void discardFallenEnemies(){
        engagedArea.cleanUpEngagedEnemyArea();
        encounterZone.discardDeadEnemies();
    }
}
