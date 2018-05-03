//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import javax.swing.JTextArea;


/**
 *
 * @author Amanda
 */
public class QueryAllyDamageView extends JTextArea{
    
    public QueryAllyDamageView (int x, int y, int damage){
        super("Damage: " +damage);
        this.setBounds(x, y, 180, 25);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setEditable(false);
        Font cardFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 16);
        this.setFont(cardFont);
        this.setBackground(Color.yellow);
    }
}
