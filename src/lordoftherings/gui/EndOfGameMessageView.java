/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lordoftherings.gui;

import java.awt.Color;
import javax.swing.JTextArea;
import lordoftherings.GameConfiguration;
import lordoftherings.gui.EncounterZoneComponents.EncounterZoneView;
import lordoftherings.gui.PlayerZoneComponents.PlayerZoneView;

/**
 *
 * @author Amanda
 */
public class EndOfGameMessageView extends JTextArea{
    
    
    public EndOfGameMessageView(int x, int y, String message, GameConfiguration config){
        this.setBounds(config.scale(x), config.scale(y), EncounterZoneView.ZONE_WIDTH, PlayerZoneView.ZONE_HEIGHT);
        this.setFont(config.getFonts().getEndOfGameFont());
        this.setForeground(Color.BLACK);
        setLineWrap(true);
        setWrapStyleWord(true);
        this.setText(message.toUpperCase());
        this.setOpaque(true);
    }
}
