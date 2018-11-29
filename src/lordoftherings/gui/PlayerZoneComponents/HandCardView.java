//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import static lordoftherings.GameConfiguration.scale;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.HandCardViewController;

/**
 *
 * @author Amanda
 */
public class HandCardView extends JTextArea {
    public static final int CARD_HEIGHT = scale(200);
    public static final int CARD_WIDTH = scale(144);
    
    public HandCardView(HandCardViewController cardVC, String cardInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(cardInfo, 0);
        this.setEditable(false);
        setBounds(scale(x), scale(y), CARD_WIDTH, CARD_HEIGHT);
        setFont(AllyCardView.CARD_FONT);
        setBackground(Color.lightGray);
        setLineWrap(true);
        setWrapStyleWord(true);
        BoardActiveState bas = cardVC.getBoardActiveStateController();
        addMouseListener(new ActionableMouseListener(bas, cardVC));
    }
}
