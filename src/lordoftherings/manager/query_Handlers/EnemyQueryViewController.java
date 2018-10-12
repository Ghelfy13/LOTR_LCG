//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.awt.Point;
import lordoftherings.boardcomponents.EncounterZone;
import lordoftherings.boardcomponents.EnemyArea;
import lordoftherings.boardcomponents.EngagedEnemyArea;
import lordoftherings.characters.Enemy;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
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
    public static int X_VALUE_FOR_ENGAGEMENT = DISTANCE_FROM_FRAME + DECK_X +
            HandCardView.CARD_WIDTH + 20;;
    public static int Y_VALUE_FOR_ENGAGEMENT = ActiveLocationView.CARD_COUNTER_HEIGHT + 
                DISTANCE_BETWEEN_ENCOUNTER_PLAYER_ZONE;;
    public static int X_VALUE_FOR_ENEMY_AREA = DISTANCE_FROM_FRAME + HandCardView.CARD_WIDTH + 
                DISTANCE_BT_DECK_AND_STAGE + 190 + ActiveLocationView.PARENT_WIDTH + 65;
    public static int Y_VALUE_FOR_ENEMY_AREA = 
            EncounterZoneViewController.Y_VALUE_FOR_STAGING_AREA + DISTANCE_FROM_FRAME;
    
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
        QueryMessageView messageView = messageVC.makeView(1995, 0, description);
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
