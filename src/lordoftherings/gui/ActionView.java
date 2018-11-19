//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    public static final int BOX_DIMENSIONS = 40;
    
    public ActionView(BoardActiveState boardAS, ActionViewController controller, Action playableAction,ImageIcon icon, int x, int y){
        super(icon);
        setBounds(x, y, BOX_DIMENSIONS, BOX_DIMENSIONS);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setLayout(null);
        setOpaque(true);
        this.addMouseListener(new FocusableMouseListener(boardAS,controller));
        ActionExecutor executor = new ActionExecutor(boardAS, playableAction);
        this.addActionListener(executor);
        if(playableAction.isAvailable()){
            setBackground(Color.white);
        }else if(!playableAction.isExecutable()){
            setBackground(Color.ORANGE);
        }
    }
    
    
}
