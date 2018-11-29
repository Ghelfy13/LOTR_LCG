//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.AllyCardView;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class EncounterDiscardCardView extends JTextArea{
      
    public EncounterDiscardCardView(int x, int y, String info){
        setText(info);
        setOpaque(true);
        setLayout(null);
        setEditable(false);
        setBackground(Color.LIGHT_GRAY);
        setFont(AllyCardView.CARD_FONT);
        setBounds(scale(x), scale(y), HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
    }
}
