//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import lordoftherings.manager.EncounterZoneControllerComponents.EnemyCardViewController;

/**
 *
 * @author Amanda
 */
public class EnemyCardView extends JTextArea{
    
    public EnemyCardView(EnemyCardViewController controller, String enemyInfo, int x, int y){
        this.setRows(11);
        this.setColumns(1);
        this.insert(enemyInfo, 0);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 12);
        this.setFont(cardFont);
        this.setEditable(false);
        this.setBackground(Color.LIGHT_GRAY);
        setBounds(x, y, HandCardView.CARD_WIDTH, HandCardView.CARD_HEIGHT);
        
    }
}
