//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.query_components.EnemyQueryEnemyAreaView;
import lordoftherings.gui.query_components.EnemyQueryEngagedEnemyAreaView;
import lordoftherings.gui.query_components.EnemyQueryView;
import lordoftherings.gui.query_components.QueryMessageView;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE;
import static lordoftherings.manager.BoardControllerComponents.BoardViewController.DISTANCE_FROM_FRAME;
import lordoftherings.manager.BoardControllerComponents.GameManagerViewController;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController;
import static lordoftherings.manager.EncounterZoneControllerComponents.EncounterZoneViewController.DISTANCE_BT_DECK_AND_STAGE;
import static lordoftherings.manager.PlayerZoneControllerCompoents.PlayerZoneViewController.DECK_X;
import lordoftherings.manager.actionComponents.GlobalViewController;
import static lordoftherings.manager.query_Handlers.CharacterQueryViewController.MESSAGE_X;
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
    private GameConfiguration config;
    private EngagedEnemyArea engagedArea;
    private EncounterZone encounterZone;
    public static int X_VALUE_FOR_ENGAGEMENT = DISTANCE_FROM_FRAME + DECK_X +164;
    public static int Y_VALUE_FOR_ENGAGEMENT = 225 + DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE;
    public static int X_VALUE_FOR_ENEMY_AREA = DISTANCE_FROM_FRAME +  
                DISTANCE_BT_DECK_AND_STAGE + 555;
    public static int Y_VALUE_FOR_ENEMY_AREA = 
            EncounterZoneViewController.Y_VALUE_FOR_STAGING_AREA + DISTANCE_FROM_FRAME;
    
    public EnemyQueryViewController(GameManagerViewController gameMVC, 
            EnemyQueryHandle handle, GameConfiguration config) {
        super(gameMVC, handle, config);
        this.enemyQAS = new EnemyQueryActiveState(this);
        this.enemyAreaVC = new EnemyQueryEnemyAreaViewController(this, 
            gameMVC.getBoard().getEncounterZone(),
            enemyQAS, config);
        this.engagedEnemyAreaVC = new EnemyQueryEngagedEnemyAreaViewController(this,
            gameMVC.getBoard().getCurrentPlayerZone().getEngagementArea(), enemyQAS, config);
        this.engagedArea = gameMVC.getBoard().getCurrentPlayerZone().getEngagementArea();
        this.encounterZone = gameMVC.getBoard().getEncounterZone();
    }

    @Override
    public EnemyQueryView makeView(String description) {
        view = new EnemyQueryView(config);
        view.add(enemyQAS.getFocusableText());
        view.addMouseMotionListener(enemyQAS.createMouseFollower());
        QueryMessageView messageView = messageVC.makeView(MESSAGE_X, 0, description);
        view.add(messageView);
        EnemyQueryEnemyAreaView enemyAreaView = enemyAreaVC.makeView(X_VALUE_FOR_ENEMY_AREA, Y_VALUE_FOR_ENEMY_AREA);
        EnemyQueryEngagedEnemyAreaView engagedEnemyAreaView = 
                engagedEnemyAreaVC.makeView(X_VALUE_FOR_ENGAGEMENT, Y_VALUE_FOR_ENGAGEMENT);
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
