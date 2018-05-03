//Copyright Amanda V. Harris 2018-present. All Rights Reserved.

package lordoftherings.gui.query_components;

import javax.swing.JPanel;

/**
 *
 * @author Amanda
 */
public class QueryHeroAreaView extends JPanel{
    private int length;
    
    public QueryHeroAreaView(int x, int y, int numOfHeros){
        length = numOfHeros*255;
        setBounds(x, y, length, 275);
        setOpaque(false);
        setLayout(null);
    }
    
    public int getLength(){
        return length;
    }
}
