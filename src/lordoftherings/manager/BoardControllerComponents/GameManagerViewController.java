//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import java.awt.Point;
import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.BoardView;
import lordoftherings.gui.EndOfGameView;
import lordoftherings.gui.GameManagerView;
import lordoftherings.gui.GlassPaneView;
import lordoftherings.gui.query_components.CharacterQueryView;
import lordoftherings.gui.query_components.QueryView;
import lordoftherings.manager.actionComponents.GlobalViewController;
import lordoftherings.manager.query_Handlers.GuiCharacterQueryHandler;
import lordoftherings.manager.query_Handlers.CharacterQueryViewController;
import lordoftherings.manager.query_Handlers.QueryViewController;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.GameManager;

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
    
    public GameManagerViewController(GameManager manager){
        this.manager = manager;
        manager.setCustomQueryHandler(new GuiCharacterQueryHandler(this));
        this.boardVC = new BoardViewController(manager.getBoard(), this);
        this.glassPane = null;
        this.queryVC = null;
        this.endOfGameVC = new EndOfGameViewController(manager.getBoard());
    }
    
    public GameManagerView makeView(int x, int y){
        view = new GameManagerView(x, y);
        glassPane = new GlassPaneView(GameManagerView.WINDOW_WIDTH, GameManagerView.WINDOW_LENGTH);
        BoardView boardV = boardVC.makeView(x, y, GameManagerView.WINDOW_WIDTH, GameManagerView.WINDOW_LENGTH);
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
        queryVC = new CharacterQueryViewController(this, handle);
        QueryView backdrop = queryVC.makeView(descriptionOfQuest);
        view.add(backdrop, new Integer(2));
        backdrop.setVisible(true);
    }
    

    public void deactivateCharQueryVC() {
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
