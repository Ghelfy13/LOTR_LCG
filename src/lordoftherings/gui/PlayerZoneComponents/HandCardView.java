//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.HandCardViewController;

/**
 *
 * @author Amanda
 */
public class HandCardView extends JTextArea {
    public static final int CARD_HEIGHT = 210;
    public static final int CARD_WIDTH = 144;
    
    public HandCardView(HandCardViewController cardVC, String cardInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(cardInfo, 0);
        this.setEditable(false);
        setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
        setFont(AllyCardView.CARD_FONT);
        setBackground(Color.lightGray);
        setLineWrap(true);
        setWrapStyleWord(true);
        BoardActiveState bas = cardVC.getBoardActiveStateController();
        // TODO: remove if
        if (cardVC != null) {
            addMouseListener(new ActionableMouseListener(bas, cardVC));
        }
    }
    
}
