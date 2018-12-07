//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.manager.actionComponents.ActionableMouseListener;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.HandCardViewController;

/**
 *
 * @author Amanda
 */
public class HandCardView extends JTextArea {
    public static final int CARD_HEIGHT = 200;
    public static final int CARD_WIDTH = 144;
    
    public HandCardView(HandCardViewController cardVC, String cardInfo, 
            int x, int y, GameConfiguration config){
        this.setRows(11);
        this.setColumns(1);
        this.insert(cardInfo, 0);
        this.setEditable(false);
        setBounds(config.scale(x), config.scale(y), 
                config.scale(CARD_WIDTH), config.scale(CARD_HEIGHT));
        setFont(config.getFonts().getCardFont());
        setBackground(Color.lightGray);
        setLineWrap(true);
        setWrapStyleWord(true);
        BoardActiveState bas = cardVC.getBoardActiveStateController();
        addMouseListener(new ActionableMouseListener(bas, cardVC));
    }
}
