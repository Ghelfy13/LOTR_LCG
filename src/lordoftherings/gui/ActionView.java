//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import lordoftherings.manager.BoardControllerComponents.ActionExecutor;
import lordoftherings.actions.Action;
import lordoftherings.manager.actionComponents.ActionViewController;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class ActionView extends JButton{
    
    public ActionView(BoardActiveState boardAS, ActionViewController controller, Action playableAction, int x, int y){
        //TODO: ActionImageManager gets playableActions icon and this will be set on the button
        //TODO: Look at DeckView for reference on how to clean this up
        setBounds(x, y, 50 , 50);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        this.addMouseListener(new FocusableMouseListener(boardAS,controller));
        ActionExecutor executor = new ActionExecutor(boardAS, playableAction);
        this.addActionListener(executor);
        if(playableAction.isExecutable()){
            setBackground(Color.BLACK);
        }else{
            setBackground(Color.white);
        }
    }
}
