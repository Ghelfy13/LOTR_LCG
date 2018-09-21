//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.query_Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.boardcomponents.AllyArea;
import lordoftherings.characters.Ally;
import lordoftherings.gui.query_components.QueryAllyView;
import lordoftherings.gui.query_components.QueryAllyZoneView;
import lordoftherings.manager.PlayerZoneControllerCompoents.AllyZoneViewController;
import lordoftherings.transaction_managers.CharacterQueryHandle;

/**
 *
 * @author Amanda
 */
public class QueryAllyZoneViewController {
    private AllyArea allyZone;
    private QueryCharacterAreaViewController charAreaVC;
    private QueryAllyZoneView view;
    private HashMap<Ally, QueryAllyViewController> controllerMap;
    private CharacterQueryActiveState charQAS;
    
    public QueryAllyZoneViewController(AllyArea allyZone, 
            QueryCharacterAreaViewController charAreaVC, CharacterQueryActiveState charQAS){
        this.allyZone = allyZone;
        this.charAreaVC = charAreaVC;
        view = null;
        controllerMap = new HashMap<>();
        this.charQAS = charQAS;
    }
    
    public QueryAllyZoneView makeView(int x, int y){
        CharacterQueryHandle handle = charAreaVC.getHandle();
        view = new QueryAllyZoneView(x, y);
        view.addMouseMotionListener(charQAS.createMouseFollower());
        ArrayList<Ally> listOfAllies = allyZone.getAllies();
        QueryAllyViewController allyVC;
        for(int i = 0; i < listOfAllies.size(); ++i){
            Ally currentAlly = listOfAllies.get(i);
            if(handle.getMatcher().matches(currentAlly)){
                allyVC = new QueryAllyViewController(currentAlly, charQAS);
                controllerMap.put(currentAlly, allyVC);
                QueryAllyView allyView = allyVC.makeView(i*AllyZoneViewController.CARDS_AND_SPACE, 0);
                allyView.setVisible(true);
                view.add(allyView);
            }
        }
        view.setVisible(true);
        return view;
    }
    
    public void updateView(){
        HashSet<Ally> allysToRemove = new HashSet<>();
        for(Map.Entry<Ally, QueryAllyViewController> entry: controllerMap.entrySet()){
            if(allyZone.findAlly(entry.getKey()) == -1){
                allysToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        
        for(Ally deadAlly: allysToRemove){
            controllerMap.remove(deadAlly);
        }
        
        for(int i = 0; i < allyZone.getSize(); ++i){
            Ally existingAlly = allyZone.getAllyAt(i);
            if(!controllerMap.containsKey(existingAlly)){
                QueryAllyViewController allyVC = new QueryAllyViewController(existingAlly, charQAS);
                QueryAllyView newAllyView = allyVC.makeView(i*AllyZoneViewController.CARDS_AND_SPACE, 0);
                view.add(newAllyView);
                controllerMap.put(existingAlly, allyVC);
            }else{
                QueryAllyViewController allyVC = controllerMap.get(existingAlly);
                allyVC.updateView();
            }
        }
        view.revalidate();
        view.repaint();
    }
}
