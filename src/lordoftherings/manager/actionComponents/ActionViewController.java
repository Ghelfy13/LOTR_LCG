//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.manager.actionComponents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import lordoftherings.actions.Action;
import lordoftherings.gui.ActionView;

/**
 *
 * @author Amanda
 */
public class ActionViewController implements Focusable {
    private ActionView view;
    private AvailableActionsViewController aaVC;
    private Action wantedAction;
    private BoardActiveState boardAS;
    
    public ActionViewController(Action newAction, AvailableActionsViewController aaVC){
        this.wantedAction = newAction;
        this.aaVC = aaVC;
        this.boardAS = aaVC.getBAS();
    }
    
    public ActionView makeView(int x, int y){
        if(wantedAction.isExecutable()){
            view = new ActionView(boardAS, this, wantedAction, availableCardBackImage(40, 40), x, y);
        }else if(wantedAction.isAvailable()){
            view = new ActionView(boardAS, this, wantedAction, visibleCardBackImage(40, 40), x, y);
        }else{
            view = new ActionView(boardAS, this, wantedAction, null, x, y);
        }
        view.setVisible(true);
        return view;
    }
    
    @Override
    public String getViewingText() {
        return wantedAction.getDescription();
    }
    
    public BoardActiveState getBAS(){
        return aaVC.getBAS();
    }
    
    public static ImageIcon availableCardBackImage(int width, int length){// h = 25, w = 18
        Image deckImage = null;
        try {
            deckImage = ImageIO.read(new File("resources/actionImage.jpg"));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        BufferedImage resizedImg = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
        Graphics2D lotrImg = resizedImg.createGraphics();
        lotrImg.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        lotrImg.drawImage(deckImage, 0, 0, width, length, null);
        lotrImg.dispose();
        return new ImageIcon(resizedImg);
    }
    
    public static ImageIcon visibleCardBackImage(int width, int length){// h = 25, w = 18
        Image deckImage = null;
        try {
            deckImage = ImageIO.read(new File("resources/actionImage_visible.jpg"));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        BufferedImage resizedImg = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
        Graphics2D lotrImg = resizedImg.createGraphics();
        lotrImg.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        lotrImg.drawImage(deckImage, 0, 0, width, length, null);
        lotrImg.dispose();
        return new ImageIcon(resizedImg);
    }
}
