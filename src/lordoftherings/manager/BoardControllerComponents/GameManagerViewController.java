//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.BoardControllerComponents;

import lordoftherings.boardcomponents.Board;
import lordoftherings.gui.BoardView;
import lordoftherings.gui.GameManagerView;
import lordoftherings.gui.GlassPaneView;
import lordoftherings.gui.query_components.CharacterQueryView;
import lordoftherings.manager.query_Handlers.GuiCharacterQueryHandler;
import lordoftherings.manager.query_Handlers.CharacterQueryViewController;
import lordoftherings.transaction_managers.CharacterQueryHandle;
import lordoftherings.transaction_managers.GameManager;

/**
 *
 * @author Amanda
 */
public class GameManagerViewController {
    private GameManager manager;
    private GameManagerView view;
    private BoardViewController boardVC;
    private GlassPaneView glassPane;
    private CharacterQueryViewController charQueryVC;
    
    public GameManagerViewController(GameManager manager){
        this.manager = manager;
        manager.setCustomQueryHandler(new GuiCharacterQueryHandler(this));
        this.boardVC = new BoardViewController(manager.getBoard(), this);
        this.glassPane = null;
        this.charQueryVC = null;
        
    }
    
    public GameManagerView makeView(int x, int y){
        view = new GameManagerView(x, y);
        glassPane = new GlassPaneView(GameManagerView.WINDOW_WIDTH, GameManagerView.WINDOW_LENGTH);
        BoardView boardV = boardVC.makeView(x, y, GameManagerView.WINDOW_WIDTH, GameManagerView.WINDOW_LENGTH);
        glassPane.setVisible(false);
        view.add(glassPane, new Integer(1));
        view.add(boardV, new Integer(0));
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        boardVC.updateView();
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
        charQueryVC = new CharacterQueryViewController(this, handle);
        CharacterQueryView backdrop = charQueryVC.makeView(descriptionOfQuest);
        view.add(backdrop, new Integer(2));
        backdrop.setVisible(true);
    }
    

    public void deactivateCharQueryVC() {
        CharacterQueryView queryView = charQueryVC.getView();
        charQueryVC = null;
        view.remove(queryView);
        setGlassPaneToInvisible();
    }
    
    public Board getBoard(){
        return manager.getBoard();
    }
    
}
