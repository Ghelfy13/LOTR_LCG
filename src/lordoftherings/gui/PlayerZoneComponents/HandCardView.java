//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.HandCardViewController;

/**
 *
 * @author Amanda
 */
public class HandCardView extends JTextArea {
    private static final int CARD_HEIGHT = 250;
    private static final int CARD_WIDTH = 180;
    
    public HandCardView(HandCardViewController cardVC, String cardInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(cardInfo, 0);
        this.setEditable(false);
        setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 14);
        setFont(cardFont);
        setBackground(Color.lightGray);
        BoardActiveState bas = cardVC.getBoardActiveStateController();
        // TODO: remove if
        if (cardVC != null) {
            addMouseListener(new ActionableMouseListener(bas, cardVC));
        }
    }
    
}
