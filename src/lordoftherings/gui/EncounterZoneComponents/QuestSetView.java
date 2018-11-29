//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView.CARD_BORDER;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.actionComponents.BoardActiveState;
import lordoftherings.manager.EncounterZoneControllerComponents.QuestSetViewController;
import lordoftherings.manager.actionComponents.FocusableMouseListener;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QuestSetView extends JLabel{
    private BoardActiveState bas;
    
    public QuestSetView(BoardActiveState bas, QuestSetViewController setVC,  int x, int y){
        super(cardBackImage(HandCardView.CARD_HEIGHT + CARD_BORDER, 
                HandCardView.CARD_WIDTH + CARD_BORDER));
        this.setBounds(scale(x), scale(y), HandCardView.CARD_HEIGHT + CARD_BORDER, 
                HandCardView.CARD_WIDTH + CARD_BORDER);
        this.bas = bas;
        this.addMouseListener(new FocusableMouseListener(bas, setVC));
        this.addMouseMotionListener(bas.createMouseFollower());
    }
    
    public static ImageIcon cardBackImage(int width, int length){
        Image deckImage = null;
        try {
            deckImage = ImageIO.read(new File("resources/questBack.jpg"));
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
