//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.Point;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.BoardView;
import lordoftherings.gui.EndOfGameView;
import lordoftherings.gui.GameManagerView;
import lordoftherings.gui.GlassPaneView;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.actionComponents.GlobalViewController;
import lordoftherings.transaction_managers.GuiCharacterQueryHandler;
import lordoftherings.manager.query_Handlers.CharacterQueryViewController;
import lordoftherings.manager.query_Handlers.EnemyQueryViewController;
import lordoftherings.transaction_managers.GuiPlayerQueryHandler;
import lordoftherings.manager.query_Handlers.PlayerQueryViewController;
import lordoftherings.manager.query_Handlers.QueryViewController;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.EnemyQueryHandle;
import lordoftherings.transaction_managers.GameManager;
import lordoftherings.transaction_managers.GuiEnemyQueryHandler;
import lordoftherings.transaction_managers.PlayerQueryHandle;

/**
 *
 * @author Amanda
 */
public class GameManagerViewController implements GlobalViewController{
    private GameManager manager;
    private GameManagerView view;
    private BoardViewController boardVC;
    private GlassPaneView glassPane;
    private QueryViewController queryVC;
    private EndOfGameViewController endOfGameVC;
    private GameConfiguration config;
    
    public GameManagerViewController(GameManager manager, GameConfiguration config){
        this.manager = manager;
        manager.setCustomCharacterQueryHandler(new GuiCharacterQueryHandler(this));
        manager.setCustomPlayerQueryHandler(new GuiPlayerQueryHandler(this));
        manager.setCustomEnemyQueryHandler(new GuiEnemyQueryHandler(this));
        //TODO: add set GUI player query here
        this.boardVC = new BoardViewController(manager.getBoard(), this, config);
        this.glassPane = null;
        this.queryVC = null;
        this.endOfGameVC = new EndOfGameViewController(manager.getBoard(), config);
        this.config = config;
    }
    
    public GameManagerView makeView(int x, int y){
        view = new GameManagerView(x, y, config);
        glassPane = new GlassPaneView(view.getWidth(), view.getHeight());
        BoardView boardV = boardVC.makeView(x, y);
        EndOfGameView endView = endOfGameVC.makeView();
        view.add(endView);
        glassPane.setVisible(false);
        view.add(glassPane, new Integer(1));
        view.add(boardV, new Integer(0));
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        boardVC.updateView();
        if(manager.getBoard().hasGameEnded()){
            setGlassPaneToVisible();
            glassPane.updateView();
            endOfGameVC.updateView();
        }
        glassPane.updateView();
        view.revalidate();
        view.repaint();
    }
    
    public void setGlassPaneToVisible(){
        glassPane.setVisible(true);
    }
    
    public void setGlassPaneToInvisible(){
        glassPane.setVisible(false);
    }

    public void setUpCharacterQuery(String descriptionOfQuest, CharacterQueryHandle handle) {
        queryVC = new CharacterQueryViewController(this, handle, config);
        QueryView backdrop = queryVC.makeView(descriptionOfQuest);
        view.add(backdrop, new Integer(2));
        backdrop.setVisible(true);
    }
    
    public void setUpPlayerQuery(PlayerQueryHandle handle, String descriptionOfAction){
        queryVC = new PlayerQueryViewController(this, handle, config);
        QueryView backdrop = queryVC.makeView(descriptionOfAction);
        view.add(backdrop, new Integer(2));
        backdrop.setVisible(true);
    }
    
    public void setUpEnemyQuery(EnemyQueryHandle handle, String descriptionOfAction){
        queryVC = new EnemyQueryViewController(this, handle, config);
        QueryView backDrop = queryVC.makeView(descriptionOfAction);
        view.add(backDrop, new Integer(2));
        backDrop.setVisible(true);
    }
    
    public GameManagerView getView(){
        return view;
    }

    public void deactivateQueryVC() {
        QueryView queryView = queryVC.getView();
        queryVC = null;
        view.remove(queryView);
        setGlassPaneToInvisible();
    }
    
    public Board getBoard(){
        return manager.getBoard();
    }

    @Override
    public Point getMousePosition() {
        return view.getMousePosition();
    }
    
}
