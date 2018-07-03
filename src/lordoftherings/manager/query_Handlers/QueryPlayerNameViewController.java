//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import lordoftherings.gui.query_components.QueryPlayerNameView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.Selectable;

/**
 *
 * @author Amanda
 */
public class QueryPlayerNameViewController implements Selectable<Integer>{//playerID/Integer
    
    private PlayerQueryActiveState playerQAS;
    private String nameOfPlayer;
    private QueryPlayerNameView nameView;
    private boolean isSelected;
    private int playerNum;
    
    public QueryPlayerNameViewController(String name, PlayerQueryActiveState playerQAS, int playerNum){
        this.playerQAS = playerQAS;
        this.nameOfPlayer = name;
        this.isSelected = false;
        this.playerNum = playerNum;
    }
    
    public QueryPlayerNameView makeView(int x, int y){
        nameView = new QueryPlayerNameView(x, y, nameOfPlayer);
        nameView.addMouseMotionListener(playerQAS.createMouseFollower());
        nameView.setVisible(true);
        return nameView;
    }
    
    public void updateView(){
        if(isSelected){
            nameView.setBorder(BoardActiveState.ACTIVE_BORDER);
        }else{
            nameView.setBorder(BoardActiveState.INACTIVE_BORDER);
        }
        nameView.revalidate();
        nameView.repaint();
    }

    @Override
    public void onSelect() {
        isSelected = true;
        updateView();
    }

    @Override
    public void onDeselect() {
        isSelected = false;
        updateView();
    }

    @Override
    public Integer get() {
        return playerNum;
    }

    @Override
    public String getViewingText() {
        return "";
    }

    
}
