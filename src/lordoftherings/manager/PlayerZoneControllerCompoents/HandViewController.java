//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.PlayerZoneControllerCompoents;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import lordoftherings.GameConfiguration;
import lordoftherings.boardcomponents.Hand;
import lordoftherings.cards.PlayerCard;
import lordoftherings.gui.EncounterZoneComponents.ActiveLocationView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.gui.PlayerZoneComponents.HandView;
import lordoftherings.manager.actionComponents.BoardActiveState;

/**
 *
 * @author Amanda
 */
public class HandViewController{
    private Hand playersHand;
    private PlayerZoneViewController playerVC;
    private HashMap<PlayerCard, HandCardViewController> controllerMap;
    private HandView view;
    private BoardActiveState bas;
    private GameConfiguration config;
    
    public HandViewController(PlayerZoneViewController playerViewController, 
            Hand playersHand, BoardActiveState bas, GameConfiguration config){
        this.playerVC = playerViewController;
        this.playersHand = playersHand;
        this.controllerMap = new HashMap<>();
        this.view = null;
        this.bas = bas;
        this.config = config;
    }
    //TODO: write methods for onSetActionable() and onUnSetActionalbe();
    
    public HandView makeView(int x, int y){
        int size = playersHand.getSizeOfHand();
        view = new HandView(x, y, config);
        view.addMouseMotionListener(bas.createMouseFollower());
        for(int i = 0; i < size; ++i){
            PlayerCard card = playersHand.getCardAt(i);
            HandCardViewController controller = new HandCardViewController(this, card, bas, config);
            HandCardView cardView = controller.makeView(ActiveLocationView.PARENT_WIDTH*i, 0);
            view.add(cardView);
            controllerMap.put(card, controller);
        }
        view.setVisible(true);
        return view;
    }
    
       
    public void updateView(){//can't edit set's or hash's while working inside of them.
        HashSet<PlayerCard> cardsToRemove = new HashSet<>();
        for(Map.Entry<PlayerCard,HandCardViewController> entry: controllerMap.entrySet()){//finding cards to remove from hand
            if(playersHand.findCard(entry.getKey()) == -1){
                cardsToRemove.add(entry.getKey());
                view.remove(entry.getValue().getView());
            }
        }
        for(PlayerCard card: cardsToRemove){//removes non-existant cards from hashMap
            controllerMap.remove(card);
        }
        int size = playersHand.getSizeOfHand();
        for(int i = 0; i < size; ++i){//adds new cards in hand to the hashmap
            PlayerCard card = playersHand.getCardAt(i);
            if(!controllerMap.containsKey(card)){
                HandCardViewController controller = new HandCardViewController(this, card, bas, config);
                HandCardView newCardView = controller.makeView(ActiveLocationView.PARENT_WIDTH*i, 0);
                view.add(newCardView);
                controllerMap.put(card, controller);
            } else{
                HandCardViewController cardController = controllerMap.get(card);
                cardController.updateView(ActiveLocationView.PARENT_WIDTH*i, 0);
            }
        }
        view.revalidate();
        view.repaint();
    }
       
}
