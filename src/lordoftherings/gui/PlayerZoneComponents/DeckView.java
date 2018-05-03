//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.PlayerZoneComponents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.PlayerZoneControllerCompoents.DeckViewController;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class DeckView extends JLabel{
    
    public DeckView(DeckViewController controller){
        super(cardBackImage(180, 250));
        this.setBounds(250,300,180,250);
        BoardActiveState bas = controller.getBoardActiveStateController();
        this.addMouseListener(new FocusableMouseListener(bas,controller));
    }
    
    public static ImageIcon cardBackImage(int width, int length){// h = 25, w = 18
        Image deckImage = null;
        try {
            deckImage = ImageIO.read(new File("resources/playerCard_Back.jpg"));
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
