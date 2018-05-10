//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.boardcomponents.AllyArea;
import lordoftherings.characters.Ally;
import lordoftherings.gui.PlayerZoneComponents.AllyView;
import lordoftherings.gui.PlayerZoneComponents.AllyZoneView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class AllyZoneViewController{
    private AllyArea myAllyArea;
    private CharacterAreaViewController characterAreaVC;
    private AllyZoneView view;
    private HashMap<Ally, AllyViewController> controllerMap;
    private BoardActiveState bas;
    public static final int CARDS_AND_SPACE = 205;
    
    public AllyZoneViewController(CharacterAreaViewController charAreaVC, AllyArea allyZone, BoardActiveState bas){
        this.characterAreaVC = charAreaVC;
        this.myAllyArea = allyZone;
        this.view = null;
        this.controllerMap = new HashMap<>();
        this.bas = bas;
    }
    
    public AllyZoneView makeView(int x, int y){
        view = new AllyZoneView(x, y);
        view.addMouseMotionListener(bas.createMouseFollower());
        for(int i = 0; i < myAllyArea.getSize(); ++i){
            Ally card = myAllyArea.getAllyAt(i);
            AllyViewController allyViewController = new AllyViewController(myAllyArea.getAllyAt(i), this, bas);
            controllerMap.put(card, allyViewController);
            AllyView allyView = allyViewController.makeView(i*CARDS_AND_SPACE, 0);
            view.add(allyView);   
        }
        view.setVisible(true);
        return view;
    }
    
    public BoardActiveState getBoardActiveStateController(){
        return bas;
    }
    
    public void updateView(){
        HashSet<Ally> allysToRemove = new HashSet<>();
        for(Map.Entry<Ally, AllyViewController> entry: controllerMap.entrySet()){
            if(myAllyArea.findAlly(entry.getKey()) == -1){
                allysToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        for(Ally deadAlly: allysToRemove){
            controllerMap.remove(deadAlly);
        }
        
        for(int i = 0; i < myAllyArea.getSize(); ++i){
            Ally existingAlly = myAllyArea.getAllyAt(i);
            if(!controllerMap.containsKey(existingAlly)){
                AllyViewController allyVC = new AllyViewController(existingAlly, this, bas);
                AllyView newAllyView = allyVC.makeView(i*CARDS_AND_SPACE, 0);
                view.add(newAllyView);
                controllerMap.put(existingAlly, allyVC);
            }else{
                AllyViewController allyVC = controllerMap.get(existingAlly);
                allyVC.updateView(i*CARDS_AND_SPACE, 0);
            }
        }
        view.revalidate();
        view.repaint();
    }
    
    public AllyZoneView getView(){
        return view;
    }

   
}
