//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import static lordoftherings.GameConfiguration.scale;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.EncounterZoneControllerComponents.EncounterDeckViewController;
import lordoftherings.manager.actionComponents.FocusableMouseListener;

/**
 *
 * @author Amanda
 */
public class EncounterDeckView extends JLabel{
    public static final int DIMENSIONS = scale(10);
    
    public EncounterDeckView(EncounterDeckViewController controller){
        super(cardBackImage(HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT));
        this.setBounds(DIMENSIONS, DIMENSIONS, HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
        BoardActiveState bas = controller.getBoardActiveStateController();
        this.addMouseListener(new FocusableMouseListener(bas,controller));
        this.addMouseMotionListener(bas.createMouseFollower());
    }
    
    public static ImageIcon cardBackImage(int width, int length){// h = 25, w = 18
        Image deckImage = null;
        try {
            deckImage = ImageIO.read(new File("resources/lotrEnemy.png"));
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
