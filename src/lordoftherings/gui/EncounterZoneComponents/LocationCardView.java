//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.manager.EncounterZoneControllerComponents.LocationCardViewController;

/**
 *
 * @author Amanda
 */
public class LocationCardView extends JTextArea {
    private static final int CARD_HEIGHT = 250;
    private static final int CARD_WIDTH = 180;
    
    public LocationCardView(LocationCardViewController controller, String locationInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(locationInfo, 0);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 14);
        this.setFont(cardFont);
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);
        
    }
}
