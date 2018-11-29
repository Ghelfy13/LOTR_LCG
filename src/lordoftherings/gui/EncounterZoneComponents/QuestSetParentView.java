/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.gui.EncounterZoneComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static lordoftherings.gui.EncounterZoneComponents.EncounterDiscardPileView.CARD_BORDER;
import lordoftherings.gui.PlayerZoneComponents.HandCardView;
import static lordoftherings.GameConfiguration.scale;

/**
 *
 * @author Amanda
 */
public class QuestSetParentView extends JPanel{
    
     public QuestSetParentView(int x, int y){
        setBounds(x, y, scale(HandCardView.CARD_HEIGHT + CARD_BORDER), 
                scale(HandCardView.CARD_WIDTH + CARD_BORDER));
        setLayout(null);
        setOpaque(true);
        setBackground(Color.MAGENTA);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public QuestSetParentView getView(){
        return this;
    }
}
